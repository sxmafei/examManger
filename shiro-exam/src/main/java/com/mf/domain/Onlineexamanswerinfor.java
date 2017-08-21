package com.mf.domain;

public class Onlineexamanswerinfor extends OnlineexamanswerinforKey {
    private String selectoption;

    private Float score;

    private Float questionscore;

    public String getSelectoption() {
        return selectoption;
    }

    public void setSelectoption(String selectoption) {
        this.selectoption = selectoption == null ? null : selectoption.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getQuestionscore() {
        return questionscore;
    }

    public void setQuestionscore(Float questionscore) {
        this.questionscore = questionscore;
    }
}