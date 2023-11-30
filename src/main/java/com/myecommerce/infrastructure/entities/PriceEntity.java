package com.myecommerce.infrastructure.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Table;

import com.myecommerce.domain.models.Price;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "PRICES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private String currency;
    private LocalDateTime lastUpdate;
    private String lastUpdateBy;
    
    public static PriceEntity fromDomainModel(Price price) {
    	return new PriceEntity(price.getId(),price.getBrandId(),price.getStartDate(),price.getEndDate(),price.getPriceList(),price.getProductId(),price.getPriority(),price.getPrice(),price.getCurrency(),price.getLastUpdate(),price.getLastUpdateBy());
    }
    
    public Price toDomainModel() {
    	return new Price(id,brandId,startDate,endDate,priceList,productId,priority,price,currency,lastUpdate,lastUpdateBy);
    }
}

