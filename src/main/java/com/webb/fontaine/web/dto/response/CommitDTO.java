package com.webb.fontaine.web.dto.response;

import com.webb.fontaine.persistence.model.Contributor;
import com.webb.fontaine.persistence.model.commit.author.AuthorInfo;
import lombok.Data;

import java.util.List;

@Data
public class CommitDTO {
    private List<AuthorInfo> authorInfoList;
    private List<Contributor> contributorsList;
}
