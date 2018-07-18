package com.example.lovekeshkumar.projectmvpbase.model;

import java.util.List;

public class Comments {

    public String name;
    public String comment;
    public String time;
    public String imageUrl;
    public String likeCount;
    public List<Comments> replies;

    public Comments(String name, String comment, String time, String imageUrl, String likeCount, List<Comments> replies) {
        this.name = name;
        this.comment = comment;
        this.time = time;
        this.imageUrl = imageUrl;
        this.likeCount = likeCount;
        this.replies = replies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public List<Comments> getReplies() {
        return replies;
    }

    public void setReplies(List<Comments> replies) {
        this.replies = replies;
    }
}
