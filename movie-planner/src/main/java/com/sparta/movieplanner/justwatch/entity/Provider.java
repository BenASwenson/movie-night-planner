package com.sparta.movieplanner.justwatch.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "technical_name")
    private String technical_name;
    @Column(name = "icon_url")
    private String icon_url;
    @Transient
    private String monetization_type;
    @Transient
    private String presentation_type;
    @Transient
    private double retail_price;
    @Transient
    private String currency;
    @Transient
    private String provider_url;

    public Provider(){}

    public Provider(int id, String technical_name, String icon_url, String monetization_type, String presentation_type, double retail_price, String currency, String provider_url) {
        this.id = id;
        this.technical_name = technical_name;
        this.icon_url = icon_url;
        this.monetization_type = monetization_type;
        this.presentation_type = presentation_type;
        this.retail_price = retail_price;
        this.currency = currency;
        this.provider_url = provider_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnical_name() {
        return technical_name;
    }

    public void setTechnical_name(String technical_name) {
        this.technical_name = technical_name;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getMonetization_type() {
        return monetization_type;
    }

    public void setMonetization_type(String monetization_type) {
        this.monetization_type = monetization_type;
    }

    public String getPresentation_type() {
        return presentation_type;
    }

    public void setPresentation_type(String presentation_type) {
        this.presentation_type = presentation_type;
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

    public String getProvider_url() {
        return provider_url;
    }

    public void setProvider_url(String provider_url) {
        this.provider_url = provider_url;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", technical_name='" + technical_name + '\'' +
                ", icon_url='" + icon_url + '\'' +
                '}';
    }
}

