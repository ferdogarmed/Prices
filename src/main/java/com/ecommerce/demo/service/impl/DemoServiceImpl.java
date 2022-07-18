package com.ecommerce.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ecommerce.demo.entity.Prices;
import com.ecommerce.demo.repository.DemoRepository;
import com.ecommerce.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

	private DemoRepository repository;

	public DemoServiceImpl(final DemoRepository repository) {
		this.repository = repository;

	}

	// DUDA: No me queda claro como utilizar el campo prioriti y price_list, así que
	// he puesto que cuando obtenga más de un valor en una búsqueda, se quede con el
	// que tenga el price_list más alto.
	@Override
	public Prices findByStartDateAndEndDateAndProductIdandBrandId(LocalDateTime startDate, LocalDateTime endDate,
			Integer productId, Integer brandId) {
		Optional<List<Prices>> optionalPrices = repository.findByStartDateAndEndDateAndProductIdandBrandId(startDate,
				endDate, productId, brandId);
		log.info("Prices list received from db: {}", optionalPrices);
		Prices prices = new Prices();
		List<Prices> pricesList = new ArrayList<>();
		// check if it's present and isn't empty
		if (optionalPrices.isPresent() && !CollectionUtils.isEmpty(optionalPrices.get())) {
			pricesList = optionalPrices.get();
			if (pricesList.size() > 1) {
				log.info("Comparing Prices by priceList to get the highest of them");
				// Compare By PriceList and get the greater result from the list received
				pricesList.sort(Comparator.comparing(Prices::getPriceList));
				prices = pricesList.get(pricesList.size() - 1);
				log.info("The chosen Prices object in the list is: {}", prices);
				return prices;
			}
			// get first object found
			prices = pricesList.stream().findFirst().orElse(new Prices());
		}
		return prices;
	}

}
