package com.example.lovekeshkumar.projectmvpbase.model;

public class VideoModel {

    public String videourl;
    public String imageurl;
    public String title_video;

    public VideoModel(String videourl, String imageurl, String title_video) {
        this.videourl = videourl;
        this.imageurl = imageurl;
        this.title_video = title_video;

    }

    public VideoModel(String imageurl, String title_video) {
        this.imageurl = imageurl;
        this.title_video = title_video;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getTitle_video() {
        return title_video;
    }

    public void setTitle_video(String title_video) {
        this.title_video = title_video;
    }


    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
