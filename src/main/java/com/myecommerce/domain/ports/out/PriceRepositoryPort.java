package com.myecommerce.domain.ports.out;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.myecommerce.domain.models.Price;

public interface PriceRepositoryPort {

	Price save (Price price);
	List<Price> findAll();
	Optional<Price> findById(Long id);
	Optional<Price> findByParams(Long brandId, Long productId, LocalDateTime date);
	
}
