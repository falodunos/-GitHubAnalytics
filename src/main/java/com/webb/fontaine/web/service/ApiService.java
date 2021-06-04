package com.webb.fontaine.web.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webb.fontaine.config.AppConfig;
import com.webb.fontaine.exception.RestExceptionHandler;
import com.webb.fontaine.persistence.model.Contributor;
import com.webb.fontaine.persistence.model.GitHubRepository;
import com.webb.fontaine.persistence.model.RepositoriesDetail;
import com.webb.fontaine.persistence.model.RepositoryShortDetail;
import com.webb.fontaine.persistence.model.commit.author.AuthorInfo;
import com.webb.fontaine.web.dto.response.CommitDTO;
import com.webb.fontaine.web.dto.response.RepositoriesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class ApiService {

    @Autowired
    RestExceptionHandler restExceptionHandler;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppConfig appConfig;

    public RepositoriesDTO searchRepositories(String query ) {
        RepositoriesDTO repositoriesDTO = new RepositoriesDTO();

            RepositoriesDetail repositoriesDetail = restTemplate
                    .getForObject(appConfig.getRepositoriesPublicUrl() + query, RepositoriesDetail.class);

            if (repositoriesDetail != null) {
                System.out.println("Total Counts :: " + repositoriesDetail.getTotalCount());
                System.out.println("Incomplete Results : " + repositoriesDetail.getIncompleteResults());
                System.out.println("GitHubRepository counter :: " + repositoriesDetail.getItems().get(0).toString());

                repositoriesDTO.setIncompleteResults(repositoriesDetail.getIncompleteResults());
                repositoriesDTO.setTotalCount(repositoriesDetail.getTotalCount());

                for (GitHubRepository gitHubRepository: repositoriesDetail.getItems()) {
                    RepositoryShortDetail rsd = new RepositoryShortDetail();
                    rsd.setId(gitHubRepository.getId());
                    rsd.setName(gitHubRepository.getName());
                    rsd.setFullName(gitHubRepository.getFullName());
                    rsd.setCommitsUrl(gitHubRepository.getCommitsUrl());
                    rsd.setContributorsUrl(gitHubRepository.getContributorsUrl());
                    rsd.setDescription(gitHubRepository.getDescription());
                    repositoriesDTO.getItems().add(rsd);
                }
            }

        return repositoriesDTO;
    }

    public CommitDTO getContributorsAnalysis(String commitUrls, String contributionsUrls) {

        Gson gson = new Gson();
        CommitDTO commitDTO = new CommitDTO();

        Contributor[] response = restTemplate.getForObject(contributionsUrls, Contributor[].class);

        List<Contributor> contributors = Arrays.asList(response);
        commitDTO.setContributorsList(contributors);

        String commits = restTemplate.getForObject(commitUrls, String.class);
        JsonObject[] commitsJsonObject = gson.fromJson(commits, JsonObject[].class);
        List<JsonObject> commitsList = Arrays.asList(commitsJsonObject);

        commitsList = sortItems(commitsList);
        int counter = commitsList.size() <= 100 ? commitsList.size() : 100;

        Map<String, Double> summary = summarize(commitsList, counter);
        List<AuthorInfo> authorInfoList = buildAuthorsInformation(commitsList, summary);
        commitDTO.setAuthorInfoList(authorInfoList);

        System.out.println("summary ::" + summary.toString());

        return  commitDTO;
    }

    private List<AuthorInfo> buildAuthorsInformation(List<JsonObject> commitsList, Map<String, Double> summary) {
        List<AuthorInfo> authorInfoList = new ArrayList<>();

        Map<String, AuthorInfo> authorInfoMap = new HashMap<>();

        for (JsonObject commit: commitsList) {
            AuthorInfo authorInfo = new AuthorInfo();

            String authorLoginKey = commit.get("author").getAsJsonObject().get("login").getAsString();

            String name = commit.get("commit").getAsJsonObject().get("author").getAsJsonObject().get("name").getAsString();
            String email = commit.get("commit").getAsJsonObject().get("author").getAsJsonObject().get("email").getAsString();
            String date = commit.get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date").getAsString();
            String login = commit.get("author").getAsJsonObject().get("login").getAsString();

            authorInfo.setImpact(summary.get(authorLoginKey));
            authorInfo.setName(name);
            authorInfo.setEmail(email);
            authorInfo.setDate(date);
            authorInfo.setLogin(login);

            if (!authorInfoMap.containsKey(authorLoginKey)) {
                authorInfoMap.put(authorLoginKey, authorInfo);
            }
        }

        for (Map.Entry<String, AuthorInfo> entry : authorInfoMap.entrySet()) {
            authorInfoList.add(entry.getValue());
        }

        return authorInfoList;
    }

    private Map<String, Double> summarize(List<JsonObject> commitsList, int counter) {
        Map<String, Double> summary = new HashMap<String, Double>();

        for (JsonObject commit : commitsList) {
//            System.out.println("summary commit :: " + commit.toString());
            String authorLoginKey = commit.get("author").getAsJsonObject().get("login").getAsString();
            if (summary.containsKey(authorLoginKey)) {
                summary.put(authorLoginKey, summary.get(authorLoginKey) + 1);
            } else {
                summary.put(authorLoginKey, 1.0);
            }
        }

        for (Map.Entry<String, Double> entry : summary.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            summary.put(key, (value / counter) * 100);
        }

        return summary;
    }


    private List<JsonObject> sortItems(List<JsonObject> commitsList) {
        Collections.sort(commitsList, (o1, o2) -> {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            LocalDateTime dateTime1 = LocalDateTime.parse(o1.get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date").getAsString().replace("Z", ""), dateFormat);
            LocalDateTime dateTime2 = LocalDateTime.parse(o2.get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date").getAsString().replace("Z", ""), dateFormat);

            return dateTime2.compareTo(dateTime1);
        });
        return commitsList;
    }
}
