package com.myecommerce.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.myecommerce.application.usecases.GetPriceUseCaseImpl;
import com.myecommerce.domain.models.Price;
import com.myecommerce.domain.ports.in.GetPriceUseCase;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class PriceService implements GetPriceUseCase{

	private final GetPriceUseCaseImpl getPriceUseCaseImpl;
	
	@Override
	public Optional<Price> getPrice(Long id) {
		return getPriceUseCaseImpl.getPrice(id);
	}

	@Override
	public List<Price> getAllPrices() {
		return getPriceUseCaseImpl.getAllPrices();
	}
	
	@Override
	public Optional<Price> getPriceByParams(Long brandId, Long productId, LocalDateTime date) {
		return getPriceUseCaseImpl.getPriceByParams(brandId, productId, date);
	}

}

