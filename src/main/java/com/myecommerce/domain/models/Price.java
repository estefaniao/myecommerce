package com.myecommerce.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Price {

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
	    
}
