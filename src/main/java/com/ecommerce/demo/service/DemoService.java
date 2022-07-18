package com.ecommerce.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.demo.dto.CustomPricesDto;
import com.ecommerce.demo.entity.Prices;

public interface DemoService {
	Prices findByStartDateAndEndDateAndProductIdandBrandId(LocalDateTime startDate, LocalDateTime endDate, Integer productId, Integer brandId);
}
