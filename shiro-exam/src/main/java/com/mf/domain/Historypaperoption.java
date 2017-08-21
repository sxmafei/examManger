package com.mf.domain;

public class Historypaperoption {
    private String optionid;

    private String questionid;

    private String optioncontent;

    private Integer optionsequence;

    private Boolean isanswer;

    private String description;

    public String getOptionid() {
        return optionid;
    }

    public void setOptionid(String optionid) {
        this.optionid = optionid == null ? null : optionid.trim();
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public String getOptioncontent() {
        return optioncontent;
    }

    public void setOptioncontent(String optioncontent) {
        this.optioncontent = optioncontent == null ? null : optioncontent.trim();
    }

    public Integer getOptionsequence() {
        return optionsequence;
    }

    public void setOptionsequence(Integer optionsequence) {
        this.optionsequence = optionsequence;
    }

    public Boolean getIsanswer() {
        return isanswer;
    }

    public void setIsanswer(Boolean isanswer) {
        this.isanswer = isanswer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}