package com.ecommerce.demo.component.mapper;

import java.lang.reflect.ParameterizedType;

import org.modelmapper.ModelMapper;

public abstract class RestGenericMapper<I, O> implements RestMapper<I, O> {

    private ModelMapper modelMapper;
    private Class<I> entityClass;
    private Class<O> dtoClass;

    public RestGenericMapper(final ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
        this.entityClass = (Class<I>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
        this.dtoClass = (Class<O>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[1];
    }

    @Override
    public O toDTO(final I input) {
        return input != null ? modelMapper.map(input, dtoClass) : null;
    }

    @Override
    public I toEntity(final O input) {
        return input != null ? modelMapper.map(input, entityClass) : null;
    }
}
