package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Create by: Mukesh Yadav
 * www.androiddevelopersolutions.com
 */
public class RestResponse {

    @SerializedName("messages")
    @Expose
    private List<String> messages = null;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}