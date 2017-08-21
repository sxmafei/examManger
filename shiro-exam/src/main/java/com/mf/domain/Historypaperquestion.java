package com.mf.domain;

import java.util.Date;

public class Historypaperquestion {
    private String questionid;

    private String paperid;

    private String questioncontent;

    private Integer questionsequence;

    private String knowledgetype;

    private String type;

    private String analysis;

    private String employeeid;

    private Date uptime;

    private Float score;

    private Boolean questionsource;

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid == null ? null : paperid.trim();
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent == null ? null : questioncontent.trim();
    }

    public Integer getQuestionsequence() {
        return questionsequence;
    }

    public void setQuestionsequence(Integer questionsequence) {
        this.questionsequence = questionsequence;
    }

    public String getKnowledgetype() {
        return knowledgetype;
    }

    public void setKnowledgetype(String knowledgetype) {
        this.knowledgetype = knowledgetype == null ? null : knowledgetype.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Boolean getQuestionsource() {
        return questionsource;
    }

    public void setQuestionsource(Boolean questionsource) {
        this.questionsource = questionsource;
    }
}