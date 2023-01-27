package com.dguerrar.zara.dto;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.generic.GenericObjectDTO;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


@Data
public class BrandDTO extends RepresentationModel<BrandDTO> {


    private Long id;
    private String brandName;
}
