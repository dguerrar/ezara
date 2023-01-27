package com.dguerrar.zara.dto;

import com.dguerrar.zara.generic.GenericObjectDTO;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


@Data
public class ProductDTO  extends RepresentationModel<ProductDTO> {


    private Long id;
    private String productName;
}

