package com.mf.domain;

public class Dictionary {
    private String dictionaryid;

    private String dictionaryname;

    private String updictionaryid;

    private Boolean isuse;

    private String discription;

    public String getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid == null ? null : dictionaryid.trim();
    }

    public String getDictionaryname() {
        return dictionaryname;
    }

    public void setDictionaryname(String dictionaryname) {
        this.dictionaryname = dictionaryname == null ? null : dictionaryname.trim();
    }

    public String getUpdictionaryid() {
        return updictionaryid;
    }

    public void setUpdictionaryid(String updictionaryid) {
        this.updictionaryid = updictionaryid == null ? null : updictionaryid.trim();
    }

    public Boolean getIsuse() {
        return isuse;
    }

    public void setIsuse(Boolean isuse) {
        this.isuse = isuse;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
    }
}