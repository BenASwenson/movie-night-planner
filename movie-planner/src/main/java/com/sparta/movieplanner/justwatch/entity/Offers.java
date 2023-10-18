package com.sparta.movieplanner.justwatch.entity;

public class Offers {
    private int provider_id;
    private String monetization_type;
    private double retail_price;
    private String currency;

    private String presentation_type;
    private String raw_web;

    private Urls urls;


    public Offers(){}


    public Offers(int provider_id, String monetization_type, double retail_price, String currency, String presentation_type, String raw_web, Urls urls) {
        this.provider_id = provider_id;
        this.monetization_type = monetization_type;
        this.retail_price = retail_price;
        this.currency = currency;
        this.presentation_type = presentation_type;
        this.raw_web = raw_web;
        this.urls = urls;
    }

    public String getMonetization_type() {
        return monetization_type;
    }

    public void setMonetization_type(String monetization_type) {
        this.monetization_type = monetization_type;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPresentation_type() {
        return presentation_type;
    }

    public void setPresentation_type(String presentation_type) {
        this.presentation_type = presentation_type;
    }

    public String getRaw_web() {
        return raw_web;
    }

    public void setRaw_web(String raw_web) {
        this.raw_web = raw_web;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "provider_id=" + provider_id +
                ", monetization_type='" + monetization_type + '\'' +
                ", retail_price=" + retail_price +
                ", currency='" + currency + '\'' +
                '}';
    }
}

