package com.myecommerce.infrastructure.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myecommerce.infrastructure.entities.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

	@Query("select p from PriceEntity p where p.brandId = :brandId and p.productId = :productId and :date between p.startDate and p.endDate order by p.priority desc")
    List<PriceEntity> findByBrandIdAndProductIdAndApplicationDateOrderByPriorityDesc(
    		@Param("brandId") Long brandId, @Param("productId") Long productId, @Param("date") LocalDateTime date);
}

