package com.webb.fontaine.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class License {
    private String key;
    private String name;
    private String url;

    @JsonProperty("spdx_id")
    private String spdxId;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("html_url")
    private String htmlUrl;
}
