package com.webb.fontaine.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubRepository {

    private Long id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("private")
    private Boolean isPrivate;

    @JsonProperty("html_url")
    private String htmlUrl;

    private String description;
    private Boolean fork;
    private String url;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("pushed_at")
    private String pushedAt;

    private String homepage;
    private long size;

    @JsonProperty("stargazers_count")
    private long stargazersCount;

    @JsonProperty("watchers_count")
    private long watchersCount;

    private String language;

    @JsonProperty("forks_count")
    private long forksCount;

    @JsonProperty("open_issues_count")
    private long openIssuesCount;

    @JsonProperty("master_branch")
    private long masterBranch;

    @JsonProperty("default_branch")
    private String defaultBranch;

    private long score;

    @JsonProperty("archive_url")
    private String archiveUrl;

    @JsonProperty("assignees_url")
    private String assigneesUrl;

    @JsonProperty("blobs_url")
    private String blobsUrl;

    @JsonProperty("branches_url")
    private String branchesUrl;

    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("commits_url")
    private String commitsUrl;

    @JsonProperty("compare_url")
    private String compareUrl;

    @JsonProperty("contents_url")
    private String contentsUrl;

    @JsonProperty("contributors_url")
    private String contributorsUrl;

    @JsonProperty("deployments_url")
    private String deploymentsUrl;

    @JsonProperty("downloads_url")
    private String downloadsUrl;

    @JsonProperty("events_url")
    private String eventsUrl;

    @JsonProperty("forks_url")
    private String forksUrl;

    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;

    @JsonProperty("git_refs_url")
    private String gitRefsUrl;

    @JsonProperty("git_tags_url")
    private String gitTagsUrl;

    @JsonProperty("git_url")
    private String gitUrl;

    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;

    @JsonProperty("issue_events_url")
    private String issueEventsUrl;

    @JsonProperty("issues_url")
    private String issuesUrl;

    @JsonProperty("keys_url")
    private String keysUrl;

    @JsonProperty("labels_url")
    private String labelsUrl;

    @JsonProperty("languages_url")
    private String languagesUrl;

    @JsonProperty("merges_url")
    private String mergesUrl;

    @JsonProperty("milestones_url")
    private String milestonesUrl;

    @JsonProperty("notifications_url")
    private String notificationsUrl;

    @JsonProperty("pulls_url")
    private String pullsUrl;

    @JsonProperty("releases_url")
    private String releasesUrl;

    @JsonProperty("ssh_url")
    private String sshUrl;

    @JsonProperty("stargazers_url")
    private String stargazersUrl;

    @JsonProperty("subscribers_url")
    private String subscribersUrl;

    @JsonProperty("subscription_url")
    private String subscriptionUrl;

    @JsonProperty("tags_url")
    private String tagsUrl;

    @JsonProperty("teams_url")
    private String teamsUrl;

    @JsonProperty("trees_url")
    private String treesUrl;

    @JsonProperty("clone_url")
    private String cloneUrl;

    @JsonProperty("mirror_url")
    private String mirrorUrl;

    @JsonProperty("hooks_url")
    private String hooksUrl;

    @JsonProperty("svn_url")
    private String svnUrl;

    private String forks;

    @JsonProperty("open_issues")
    private String openIssues;

    private String watchers;

    @JsonProperty("has_issues")
    private String hasIssues;

    @JsonProperty("has_projects")
    private String hasProjects;

    @JsonProperty("has_pages")
    private String hasPages;

    @JsonProperty("has_wiki")
    private String hasWiki;

    @JsonProperty("has_downloads")
    private String hasDownloads;

    private String archived;
    private String disabled;

    private Owner owner;
    private License license;

    @Override
    public String toString() {
        return "GitHubRepository{" +
                "id=" + id +
                ", nodeId='" + nodeId + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", isPrivate=" + isPrivate +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", description='" + description + '\'' +
                ", fork=" + fork +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", pushedAt='" + pushedAt + '\'' +
                ", homepage='" + homepage + '\'' +
                ", size=" + size +
                ", stargazersCount=" + stargazersCount +
                ", watchersCount=" + watchersCount +
                ", language='" + language + '\'' +
                ", forksCount=" + forksCount +
                ", openIssuesCount=" + openIssuesCount +
                ", masterBranch=" + masterBranch +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", score=" + score +
                ", archive_url='" + archiveUrl + '\'' +
                ", assigneesUrl='" + assigneesUrl + '\'' +
                ", blobsUrl='" + blobsUrl + '\'' +
                ", branchesUrl='" + branchesUrl + '\'' +
                ", collaboratorsUrl='" + collaboratorsUrl + '\'' +
                ", commentsUrl='" + commentsUrl + '\'' +
                ", commitsUrl='" + commitsUrl + '\'' +
                ", compareUrl='" + compareUrl + '\'' +
                ", contentsUrl='" + contentsUrl + '\'' +
                ", contributorsUrl='" + contributorsUrl + '\'' +
                ", deploymentsUrl='" + deploymentsUrl + '\'' +
                ", downloadsUrl='" + downloadsUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", forksUrl='" + forksUrl + '\'' +
                ", gitCommitsUrl='" + gitCommitsUrl + '\'' +
                ", gitRefsUrl='" + gitRefsUrl + '\'' +
                ", gitTagsUrl='" + gitTagsUrl + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", issueCommentUrl='" + issueCommentUrl + '\'' +
                ", issueEventsUrl='" + issueEventsUrl + '\'' +
                ", issuesUrl='" + issuesUrl + '\'' +
                ", keysUrl='" + keysUrl + '\'' +
                ", labelsUrl='" + labelsUrl + '\'' +
                ", languagesUrl='" + languagesUrl + '\'' +
                ", mergesUrl='" + mergesUrl + '\'' +
                ", milestonesUrl='" + milestonesUrl + '\'' +
                ", notificationsUrl='" + notificationsUrl + '\'' +
                ", pullsUrl='" + pullsUrl + '\'' +
                ", releasesUrl='" + releasesUrl + '\'' +
                ", sshUrl='" + sshUrl + '\'' +
                ", stargazersUrl='" + stargazersUrl + '\'' +
                ", subscribersUrl='" + subscribersUrl + '\'' +
                ", subscriptionUrl='" + subscriptionUrl + '\'' +
                ", tagsUrl='" + tagsUrl + '\'' +
                ", teamsUrl='" + teamsUrl + '\'' +
                ", treesUrl='" + treesUrl + '\'' +
                ", cloneUrl='" + cloneUrl + '\'' +
                ", mirrorUrl='" + mirrorUrl + '\'' +
                ", hooksUrl='" + hooksUrl + '\'' +
                ", svnUrl='" + svnUrl + '\'' +
                ", forks='" + forks + '\'' +
                ", openIssues='" + openIssues + '\'' +
                ", watchers='" + watchers + '\'' +
                ", hasIssues='" + hasIssues + '\'' +
                ", hasProjects='" + hasProjects + '\'' +
                ", hasPages='" + hasPages + '\'' +
                ", hasWiki='" + hasWiki + '\'' +
                ", hasDownloads='" + hasDownloads + '\'' +
                ", archived='" + archived + '\'' +
                ", disabled='" + disabled + '\'' +
                ", owner=" + owner +
                ", license=" + license +
                '}';
    }

}
