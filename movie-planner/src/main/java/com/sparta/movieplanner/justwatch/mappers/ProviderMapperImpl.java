package com.sparta.movieplanner.justwatch.mappers;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Provider;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapperImpl implements ProviderMapper{
    @Override
    public ProviderDTO entityToDto(Provider provider) {

        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setId(provider.getId());
        providerDTO.setIcon_url(provider.getIcon_url());
        providerDTO.setTechnical_name(provider.getTechnical_name());
        providerDTO.setProvider_url(provider.getProvider_url());
        return providerDTO;
    }

    @Override
    public Provider DtoToEntity(ProviderDTO providerDTO) {

        Provider provider = new Provider();

        provider.setId(providerDTO.getId());
        provider.setProvider_url(providerDTO.getProvider_url());
        provider.setTechnical_name(providerDTO.getTechnical_name());
        provider.setIcon_url(providerDTO.getIcon_url());

        return provider;
    }
}
