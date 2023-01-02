package com.dguerrar.zara.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name="prices")
public class PriceEntry implements Serializable {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="start_date")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime startDate;

    @Column(name="end_date")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime endDate;

    @JoinColumn(name = "brand_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;


    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    @JoinColumn(name = "price_list_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PriceListEntry priceListEntry;

    @Column(name="priority")
    private Integer priority;

    @Column(name="price")
    private BigDecimal price;


}
