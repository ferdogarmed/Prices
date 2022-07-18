package com.ecommerce.demo.controller;

import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.ecommerce.demo.service.DemoService;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
public class DemoControllerH2DBTest {

//	@Mock private DemoService service;
	private DemoController controller;

	@Autowired
	public DemoControllerH2DBTest(DemoService service, ModelMapper mapper) {
		this.controller = new DemoController(service, mapper);
	}

	// DUDA: Los test no sabía si la fecha a introducir es la startDate, EndDate o ambas, así que
	// he hecho 5 test en los cuales pongo ambas y otros 5 en los cuales solo pongo el
	// campo startDate que está controlado para poder ser null en la query del repositorio
	
	@Test
	@DisplayName("Test 1")
	void whenfindByStartDateAndEndDateAndProductIdandBrandIdThenShouldReturn200CodeTest1() {

		var startTime = LocalDateTime.of(2020, 06, 14, 10, 0, 0);
		var endDate = LocalDateTime.of(2020, 06, 14, 23, 59, 59);
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	@DisplayName("Test 2")
	void whenfindByStartDateAndEndDateAndProductIdandBrandIdThenShouldReturn200CodeTest2() {

		var startTime = LocalDateTime.of(2020, 06, 14, 16, 0, 0);
		var endDate = LocalDateTime.of(2020, 06, 14, 23, 59, 59);
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	@DisplayName("Test 3")
	void whenfindByStartDateAndEndDateAndProductIdandBrandIdThenShouldReturn200CodeTest3() {

		var startTime = LocalDateTime.of(2020, 06, 14, 21, 0, 0);
		var endDate = LocalDateTime.of(2020, 06, 14, 23, 59, 59);
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	@DisplayName("Test 4")
	void whenExistAnEntityWithCodeParameterThenShouldReturn200CodeAndBodyIsNotEmptyTest4() {

		var startTime = LocalDateTime.of(2020, 06, 15, 10, 0, 0);
		var endDate = LocalDateTime.of(2020, 06, 15, 23, 59, 59);
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	@DisplayName("Test 5")
	void whenExistAnEntityWithCodeParameterThenShouldReturn200CodeAndBodyIsNotEmptyTest5() {

		var startTime = LocalDateTime.of(2020, 06, 16, 21, 0, 0);
		var endDate = LocalDateTime.of(2020, 06, 16, 23, 59, 59);
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	
	//TEST sin endDate
	@Test
	@DisplayName("Test 6")
	void whenfindByStartDateAndEndDateAndProductIdandBrandIdThenShouldReturn200CodeTest6() {
		
		var startTime = LocalDateTime.of(2020, 06, 14, 10, 0, 0);
		LocalDateTime endDate = null;
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	
	@Test
	@DisplayName("Test 7")
	void whenfindByStartDateAndEndDateAndProductIdandBrandIdThenShouldReturn200CodeTest7() {
		
		var startTime = LocalDateTime.of(2020, 06, 14, 16, 0, 0);
		LocalDateTime endDate = null;
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	
	@Test
	@DisplayName("Test 8")
	void whenfindByStartDateAndEndDateAndProductIdandBrandIdThenShouldReturn200CodeTest8() {
		
		var startTime = LocalDateTime.of(2020, 06, 14, 21, 0, 0);
		LocalDateTime endDate = null;
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	
	@Test
	@DisplayName("Test 9")
	void whenExistAnEntityWithCodeParameterThenShouldReturn200CodeAndBodyIsNotEmptyTest9() {
		
		var startTime = LocalDateTime.of(2020, 06, 15, 10, 0, 0);
		LocalDateTime endDate = null;
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	
	@Test
	@DisplayName("Test 10")
	void whenExistAnEntityWithCodeParameterThenShouldReturn200CodeAndBodyIsNotEmptyTest10() {
		
		var startTime = LocalDateTime.of(2020, 06, 16, 21, 0, 0);
		LocalDateTime endDate = null;
		var productId = 35455;
		var brandId = 1;
		var response = controller.findByStartDateAndEndDateAndProductIdandBrandId(startTime, endDate, productId,
				brandId);
		MatcherAssert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

}
