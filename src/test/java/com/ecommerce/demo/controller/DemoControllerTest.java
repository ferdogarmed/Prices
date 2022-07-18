package com.ecommerce.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import com.ecommerce.demo.dto.CustomPricesDto;
import com.ecommerce.demo.entity.Prices;
import com.ecommerce.demo.service.impl.DemoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {

    @Mock 
	private DemoServiceImpl service;
    @Mock
    private ModelMapper mapper;

    @InjectMocks private DemoController controller;

  
  @Test
  void whenExistAnEntityWithCodeParameterThenShouldReturn200CodeAndBodyIsNotEmpty() {
	  
	  var prices = getEntity();
	  var CustomPricesDto = getCustomPricesDto();
	  
	  var startTime = LocalDateTime.of(2020, 06, 13, 10, 0, 0);
	  var endDate = LocalDateTime.of(2020, 06, 15, 23, 0, 0);
	  var productId = 35455;
	  var brandId = 1;

      when(service.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId, brandId)).thenReturn(prices);
      when(mapper.map(prices, CustomPricesDto.class)).thenReturn(CustomPricesDto);
	  var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId, brandId);

	  MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	  MatcherAssert.assertThat(response.getBody(), is(IsNull.notNullValue()));
	  verify(service, VerificationModeFactory.times(1)).findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId, brandId);
	  verify(mapper, VerificationModeFactory.times(1)).map(prices, CustomPricesDto.class);
  }
  
  private Prices getEntity() {

	  var prices = new Prices();
	  prices.setId(1);
	  prices.setStartDate(LocalDateTime.of(2020, 06, 14, 13, 0, 0));
	  prices.setEndDate(LocalDateTime.of(2020, 06, 14, 14, 0, 0));
	  prices.setProductId(35455);
	  prices.setBrandId(1);
			
	  return prices;
  }
  private CustomPricesDto getCustomPricesDto() {
	  
	  var customPricesDto = new CustomPricesDto();
	  customPricesDto.setStartDate(LocalDateTime.of(2020, 06, 14, 13, 0, 0));
	  customPricesDto.setEndDate(LocalDateTime.of(2020, 06, 14, 14, 0, 0));
	  customPricesDto.setProductId(35455);
	  customPricesDto.setBrandId(1);
	  
	  return customPricesDto;
  }
    
}
