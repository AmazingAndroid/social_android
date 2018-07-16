package com.example.lovekeshkumar.projectmvpbase.model;

public class ChatShareDataResponse {
    public String image_Url;
    public String user_Name;
    public Boolean checkValue;

    public ChatShareDataResponse(String image_Url, String user_Name, Boolean checkValue) {
        this.image_Url = image_Url;
        this.user_Name = user_Name;
        this.checkValue = checkValue;
    }

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public Boolean getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Boolean checkValue) {
        this.checkValue = checkValue;
    }

}
