package com.ecommerce.demo.component.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ecommerce.demo.component.mapper.RestGenericMapper;
import com.ecommerce.demo.component.mapper.RestMapper;
import com.ecommerce.demo.dto.CustomPricesDto;
import com.ecommerce.demo.entity.Prices;

@Component
public class PricesRestMapper extends RestGenericMapper<Prices, CustomPricesDto>
    implements RestMapper<Prices, CustomPricesDto> {

    public PricesRestMapper(final ModelMapper modelMapper) {
        super(modelMapper);
    }
}
