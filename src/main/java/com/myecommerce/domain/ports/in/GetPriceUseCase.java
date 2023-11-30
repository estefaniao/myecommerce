package com.myecommerce.domain.ports.in;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.myecommerce.domain.models.Price;

public interface GetPriceUseCase {

	Optional<Price> getPrice(Long id);
	List<Price> getAllPrices();
	Optional<Price> getPriceByParams(Long brandId, Long productId, LocalDateTime date);
}
