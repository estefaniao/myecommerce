package com.myecommerce.infrastructure.adapters;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.myecommerce.domain.models.Price;
import com.myecommerce.domain.ports.out.PriceRepositoryPort;
import com.myecommerce.infrastructure.entities.PriceEntity;
import com.myecommerce.infrastructure.repositories.PriceRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort{

	private final PriceRepository priceRepository;
	
	@Override
	public Price save(Price price) {
		PriceEntity priceEntity = PriceEntity.fromDomainModel(price);
		return priceRepository.save(priceEntity).toDomainModel();
	}

	@Override
	public List<Price> findAll() {
		return priceRepository.findAll().stream().map(PriceEntity::toDomainModel).toList();
	}

	@Override
	public Optional<Price> findById(Long id) {
		return priceRepository.findById(id).map(PriceEntity::toDomainModel);
	}

	@Override
	public Optional<Price> findByParams(Long brandId, Long productId, LocalDateTime date) {
		return priceRepository.findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(brandId, productId, date).stream().map(PriceEntity::toDomainModel).findFirst();
	}

}
