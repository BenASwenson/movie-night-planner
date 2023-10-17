package com.sparta.movieplanner.justwatch.entity;

public class Urls {

    private String standard_web;
    private String raw_web;

    public Urls(){}

    public Urls(String standard_web, String raw_web) {
        this.standard_web = standard_web;
        this.raw_web = raw_web;
    }

    public String getStandard_web() {
        return standard_web;
    }

    public void setStandard_web(String standard_web) {
        this.standard_web = standard_web;
    }

    public String getRaw_web() {
        return raw_web;
    }

    public void setRaw_web(String raw_web) {
        this.raw_web = raw_web;
    }
}
