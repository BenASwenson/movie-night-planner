package com.sparta.movieplanner.justwatch.mappers;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Provider;

public interface ProviderMapper {

    ProviderDTO entityToDto(Provider provider);

    Provider DtoToEntity(ProviderDTO providerDTO);
}
