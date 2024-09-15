package com.ucb.FramkyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterServiceTests {

	private ConverterService converterService;
	private ConfigParam configParam;

	@BeforeEach
	void setUp() {

		configParam = Mockito.mock(ConfigParam.class);
		converterService = new ConverterService(configParam);
	}

	@Test
	void testCalculocelciusToFahrenheit() {

		double celsius = 0.0;
		double expectedFahrenheit = 32.0;

		double result = converterService.calculocelciusToFahrenheit(celsius);

		assertEquals(expectedFahrenheit, result, "0°C debería ser 32°F");
	}

	@Test
	void testCalculofarenheitToCelsius() {

		double fahrenheit = 32.0;
		double expectedCelsius = 0.0;

		double result = converterService.calculofarenheitToCelsius(fahrenheit);

		assertEquals(expectedCelsius, result, "32°F debería ser 0°C");
	}

	@Test
	void testCalculateDollarConversion() {

		Mockito.when(configParam.getOficialDollar()).thenReturn(6.96);

		double bolivianAmount = 100.0;
		double expectedDollar = 696.0;  // 100 * 6.96

		double result = converterService.calculateDollarConversion(bolivianAmount);

		assertEquals(expectedDollar, result, "La conversión de bolivianos a dólares no es correcta");
	}
}
