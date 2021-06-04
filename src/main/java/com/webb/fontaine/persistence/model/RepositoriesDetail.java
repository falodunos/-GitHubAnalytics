package com.webb.fontaine.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RepositoriesDetail implements Serializable {
    @JsonProperty("total_count")
    private String totalCount;

    @JsonProperty("incomplete_results")
    private String incompleteResults;

    List<GitHubRepository> items;

}
