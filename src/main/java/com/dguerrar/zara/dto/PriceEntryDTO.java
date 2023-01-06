package com.dguerrar.zara.dto;

import com.dguerrar.zara.generic.GenericObjectDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceEntryDTO extends GenericObjectDTO {

    private Long productId;
    private Long brandId;
    private Long priceListEntryId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private String currency;
    private Integer priority;


}
