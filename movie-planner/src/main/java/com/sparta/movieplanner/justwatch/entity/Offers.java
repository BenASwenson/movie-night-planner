package com.sparta.movieplanner.justwatch.entity;

public class Offers {
    private int provider_id;
    private String monetization_type;
    private double retail_price;
    private String currency;


    public Offers(){}


    public Offers(int provider_id, String monetization_type, double retail_price, String currency) {
        this.provider_id = provider_id;
        this.monetization_type = monetization_type;
        this.retail_price = retail_price;
        this.currency = currency;
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

