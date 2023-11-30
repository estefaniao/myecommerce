package com.myecommerce.application.usecases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.myecommerce.domain.models.Price;
import com.myecommerce.domain.ports.in.GetPriceUseCase;
import com.myecommerce.domain.ports.out.PriceRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPriceUseCaseImpl implements GetPriceUseCase {

	private final PriceRepositoryPort priceRepositoryPort;
	
	@Override
	public Optional<Price> getPrice(Long id) {
		return priceRepositoryPort.findById(id);
	}

	@Override
	public List<Price> getAllPrices() {
		return priceRepositoryPort.findAll();
	}

	@Override
	public Optional<Price> getPriceByParams(Long brandId, Long productId, LocalDateTime date) {
		return priceRepositoryPort.findByParams(brandId, productId, date);
	}

}
