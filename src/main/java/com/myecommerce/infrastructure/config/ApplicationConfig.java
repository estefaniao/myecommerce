package com.myecommerce.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myecommerce.application.services.PriceService;
import com.myecommerce.application.usecases.GetPriceUseCaseImpl;
import com.myecommerce.domain.ports.out.PriceRepositoryPort;
import com.myecommerce.infrastructure.adapters.PriceRepositoryAdapter;

@Configuration
public class ApplicationConfig {

	@Bean
	public PriceService priceService(PriceRepositoryPort priceRepositoryPort) {
		return new PriceService(new GetPriceUseCaseImpl(priceRepositoryPort));
	}
	
	@Bean
	public PriceRepositoryPort priceRepositoryPort(PriceRepositoryAdapter priceRepositoryAdapter) {
		return priceRepositoryAdapter;
	}
	
}

