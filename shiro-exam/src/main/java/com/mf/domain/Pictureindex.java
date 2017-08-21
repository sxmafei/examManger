package com.mf.domain;

import java.util.Date;

public class Pictureindex {
    private String pictureid;

    private String picturetype;

    private String originalname;

    private String currentname;

    private String picturesize;

    private Date uploadtime;

    private String employeeid;

    private String description;

    public String getPictureid() {
        return pictureid;
    }

    public void setPictureid(String pictureid) {
        this.pictureid = pictureid == null ? null : pictureid.trim();
    }

    public String getPicturetype() {
        return picturetype;
    }

    public void setPicturetype(String picturetype) {
        this.picturetype = picturetype == null ? null : picturetype.trim();
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname == null ? null : originalname.trim();
    }

    public String getCurrentname() {
        return currentname;
    }

    public void setCurrentname(String currentname) {
        this.currentname = currentname == null ? null : currentname.trim();
    }

    public String getPicturesize() {
        return picturesize;
    }

    public void setPicturesize(String picturesize) {
        this.picturesize = picturesize == null ? null : picturesize.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}