package com.webb.fontaine.web.dto.request;

import lombok.Value;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public enum RepositoryDTO {;

    public interface Query {
        /**
         * Query string or text-match to be searched ...
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid request reference ")
        @Size(min = 1,  message = "Invalid query, query string cannot be empty")
        String getQuery();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements Query {
            String query;
        }
    }

}
