package com.dguerrar.zara.dto;

import com.dguerrar.zara.generic.GenericObjectDTO;
import lombok.Data;


@Data
public class ProductDTO extends GenericObjectDTO {


    private Long id;
    private String productName;
}

