package com.assignment.myblog.domain;

import java.time.LocalDateTime;

public interface PostsMapping {
    Long getId();
    LocalDateTime getCreatedAt();
    String getUsername();
    String getPostname();
}
