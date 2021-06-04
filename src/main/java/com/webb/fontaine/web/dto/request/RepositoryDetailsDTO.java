package com.webb.fontaine.web.dto.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public enum RepositoryDetailsDTO {;

    public interface CommitsUrl {
        /**
         * Query string or text-match to be searched ...
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid CommitUrl ")
        @Size(min = 8,  message = "Invalid query, query string cannot be empty")
        String getCommitsUrl();
    }

    public interface ContributorsUrl {
        /**
         * Query string or text-match to be searched ...
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid ContributorsUrl ")
        @Size(min = 8,  message = "Invalid query, query string cannot be empty")
        String getContributorsUrl();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements CommitsUrl, ContributorsUrl {
            String commitsUrl;
            String contributorsUrl;
        }
    }

}
