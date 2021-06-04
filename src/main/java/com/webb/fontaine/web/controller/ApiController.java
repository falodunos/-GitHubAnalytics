package com.webb.fontaine.web.controller;

import com.webb.fontaine.web.dto.request.RepositoryDetailsDTO;
import com.webb.fontaine.web.dto.response.CommitDTO;
import com.webb.fontaine.web.dto.response.RepositoriesDTO;
import com.webb.fontaine.web.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/github/api/v1")
@Slf4j
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    ApiService apiService;

    /**
     * @return ResponseEntity
     * @throws Exception
     */
    @GetMapping(path = "/search/repositories")
    public ResponseEntity<RepositoriesDTO> searchRepositories(@RequestParam String query) {
        System.out.println("Query String " + query);
        return ResponseEntity.ok().body(apiService.searchRepositories(query));
    }

    /**
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/repository/details")
    public ResponseEntity<CommitDTO> repositoryDetails(@Valid @RequestBody RepositoryDetailsDTO.Request.Body request) {
        String commitUrls = request.getCommitsUrl();

        if (commitUrls != null)
            commitUrls = commitUrls.replace("{/sha}", "");
        String contributionsUrls = request.getContributorsUrl();

        return ResponseEntity.ok().body(apiService.getContributorsAnalysis(commitUrls, contributionsUrls));
    }
}
