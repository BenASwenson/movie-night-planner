package com.sparta.movieplanner.converters;

public interface Converter<T, K> {
    K dtoToEntity(T t);

    T entityToDto(K k);
}
