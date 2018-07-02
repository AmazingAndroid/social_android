package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Create by: Mukesh Yadav
 * www.androiddevelopersolutions.com
 */
public class Result {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("uniqueid")
    @Expose
    public String uniqueid;
    @SerializedName("fname")
    @Expose
    public String fname;
    @SerializedName("lname")
    @Expose
    public String lname;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("mobile")
    @Expose
    public String mobile;
    @SerializedName("cv")
    @Expose
    public String cv;
    @SerializedName("dob")
    @Expose
    public String dob;
    @SerializedName("nationality")
    @Expose
    public String nationality;
    @SerializedName("picture")
    @Expose
    public String picture;
    @SerializedName("work")
    @Expose
    public String work;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("rdate")
    @Expose
    public String rdate;
    @SerializedName("rtime")
    @Expose
    public String rtime;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("statuscode")
    @Expose
    public String statuscode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

}