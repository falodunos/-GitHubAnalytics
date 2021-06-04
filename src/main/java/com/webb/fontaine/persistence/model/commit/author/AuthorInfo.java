package com.webb.fontaine.persistence.model.commit.author;

import lombok.Data;

@Data
public class AuthorInfo {
    private String name;
    private String email;
    private String date;
    private Double impact;
    private String login;

    @Override
    public String toString() {
        return "AuthorInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", login='" + login + '\'' +
                ", impact='" + impact + '\'' +
                '}';
    }
}