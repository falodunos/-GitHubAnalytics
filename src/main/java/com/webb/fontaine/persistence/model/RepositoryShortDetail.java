package com.webb.fontaine.persistence.model;

import lombok.Data;

@Data
public class RepositoryShortDetail {
    private long id;
    private String nodeId;
    private String name;
    private String fullName;
    private String contributorsUrl;
    private String commitsUrl;
    private String description;

    @Override
    public String toString() {
        return "RepositoryShortDetail{" +
                "id=" + id +
                "nodeId=" + nodeId +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contributorsUrl='" + contributorsUrl + '\'' +
                ", commitsUrl='" + commitsUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
