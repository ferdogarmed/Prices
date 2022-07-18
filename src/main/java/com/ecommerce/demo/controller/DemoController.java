package com.ecommerce.demo.controller;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.dto.CustomPricesDto;
import com.ecommerce.demo.entity.Prices;
import com.ecommerce.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

	private DemoService service;
	private ModelMapper mapper;

	public DemoController(final DemoService service, final ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/findByParams")
	public ResponseEntity<CustomPricesDto> findByStartDateAndEndDateAndProductIdandBrandId(
			@RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate,
			@RequestParam(value = "productId", required = true) Integer productId,
			@RequestParam(value = "brandId", required = true) Integer brandId) {

		log.info("Received startDate: {}, endDate: {}, productId: {}, brandId: {}", startDate, endDate, productId,
				brandId);
		Prices prices = service.findByStartDateAndEndDateAndProductIdandBrandId(startDate, endDate, productId, brandId);

		ResponseEntity<CustomPricesDto> response = ResponseEntity.ok(pricesToDto(prices));
		log.info("Response: {}", response);
		return response;
	}

	private CustomPricesDto pricesToDto(Prices prices) {
		return mapper.map(prices, CustomPricesDto.class);
	}

}
