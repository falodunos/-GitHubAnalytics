package com.webb.fontaine.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webb.fontaine.persistence.model.RepositoryShortDetail;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RepositoriesDTO implements Serializable {
    @JsonProperty("total_count")
    private String totalCount;

    @JsonProperty("incomplete_results")
    private String incompleteResults;

    List<RepositoryShortDetail> items = new ArrayList<>();

}
