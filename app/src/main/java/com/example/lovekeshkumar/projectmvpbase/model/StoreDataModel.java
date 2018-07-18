package com.example.lovekeshkumar.projectmvpbase.model;

public class StoreDataModel {
    public String image_url;
    public String timeinterval;
    public Boolean islike;
    public String hashtagName;
    public String brandName;
    public String model;
    public String maxprice;
    public String priceafterDiscount;
    public Boolean isavailable;

    public StoreDataModel(String image_url, String timeinterval, Boolean islike, String hashtagName, String brandName, String model, String maxprice, String priceafterDiscount, Boolean isavailable) {
        this.image_url = image_url;
        this.timeinterval = timeinterval;
        this.islike = islike;
        this.hashtagName = hashtagName;
        this.brandName = brandName;
        this.model = model;
        this.maxprice = maxprice;
        this.priceafterDiscount = priceafterDiscount;
        this.isavailable = isavailable;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTimeinterval() {
        return timeinterval;
    }

    public void setTimeinterval(String timeinterval) {
        this.timeinterval = timeinterval;
    }

    public Boolean getIslike() {
        return islike;
    }

    public void setIslike(Boolean islike) {
        this.islike = islike;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(String maxprice) {
        this.maxprice = maxprice;
    }

    public String getPriceafterDiscount() {
        return priceafterDiscount;
    }

    public void setPriceafterDiscount(String priceafterDiscount) {
        this.priceafterDiscount = priceafterDiscount;
    }

    public Boolean getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(Boolean isavailable) {
        this.isavailable = isavailable;
    }
}
