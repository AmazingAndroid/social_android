package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 12/6/2017.
 */

public class VideoTopicResponse {
    @SerializedName("topics")
    @Expose
    public List<Topic> topics ;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
