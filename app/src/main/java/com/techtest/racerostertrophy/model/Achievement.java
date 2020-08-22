package com.techtest.racerostertrophy.model;

public class Achievement {
    private String title;
    private boolean isAchieved;
    private Integer imageResource;
    private String record;

    public Achievement(String title, boolean isAchieved, String record, Integer imageResource) {
        this.title = title;
        this.isAchieved = isAchieved;
        this.record = record;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAchieved() {
        return isAchieved;
    }

    public void setAchieved(boolean achieved) {
        isAchieved = achieved;
    }

    public Integer getImageResource() {
        return imageResource;
    }

    public void setImageResource(Integer imageResource) {
        this.imageResource = imageResource;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
