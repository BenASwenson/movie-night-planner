package com.sparta.movieplanner.justwatch.dto;

import com.sparta.movieplanner.justwatch.entity.Provider;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

public class ProviderDTO {

    private int id;

    private String technical_name;

    private String icon_url;

    private String provider_url;

    public ProviderDTO(){}

    public ProviderDTO(int id, String technical_name, String icon_url, String provider_url) {
        this.id = id;
        this.technical_name = technical_name;
        this.icon_url = icon_url;
        this.provider_url = provider_url;
    }

    public ProviderDTO(ProviderDTO provider){
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
        return "ProviderDTO{" +
                "id=" + id +
                ", technical_name='" + technical_name + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", provider_url='" + provider_url + '\'' +
                '}';
    }
}
