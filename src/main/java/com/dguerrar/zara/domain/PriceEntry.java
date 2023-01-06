package com.dguerrar.zara.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name="prices")
public class PriceEntry implements Serializable {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="start_date")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime startDate;

    @Column(name="end_date")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime endDate;

    @JoinColumn(name = "brand_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Brand brand;


    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;


    @JoinColumn(name = "price_list_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PriceListEntry priceListEntry;

    @Column(name="priority")
    private Integer priority;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="currency", length=10)
    private String currency;


}
