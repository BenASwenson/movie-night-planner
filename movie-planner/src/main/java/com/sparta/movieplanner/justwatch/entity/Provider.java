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
    private String provider_url;

    public Provider(){}

    public Provider(int id, String technical_name, String icon_url, String provider_url) {
        this.id = id;
        this.technical_name = technical_name;
        this.icon_url = icon_url;
        this.provider_url = provider_url;
    }

    public Provider(Provider provider){
        this.id = provider.getId();
        this.technical_name = provider.getTechnical_name();
        this.icon_url = provider.getIcon_url();
        this.provider_url = provider.getProvider_url();
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
                ", provider_url='" + provider_url + '\'' +
                '}';
    }
}

