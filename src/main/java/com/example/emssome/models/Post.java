package com.example.emssome.models;

import java.time.LocalDateTime;

public class Post {
    private int postId;
    private int userId;
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }


    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
