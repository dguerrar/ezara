package com.dguerrar.zara.converters.brand;

import com.dguerrar.zara.controllers.brand.BrandController;
import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.generic.GenericConverter;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BrandConverter extends GenericModule implements GenericConverter<Brand,BrandDTO> {


    public BrandDTO toDTO(Brand brand) throws Exception {
        if (brand == null){
            return null;
        }
        BrandDTO dto = new BrandDTO();
        BeanUtils.copyProperties(brand,dto);
        Link selfLink = linkTo(methodOn(BrandController.class)
                .getBrandById(brand.getId())).withSelfRel();
        dto.add(selfLink);

        return dto;
    }


    public Brand toEntity(BrandDTO dto){
        if(dto == null ){
            return null;
        }
        Brand brand = new Brand();
        BeanUtils.copyProperties(dto,brand,this.getNullPropertyNames(dto));
        return brand;
    }


    public List<BrandDTO> toDTOList(List<Brand> brands) throws Exception {
        List<BrandDTO> dataSetDTOList= new ArrayList<>();

        for (Brand dataSet: brands) {
            BrandDTO returnDTO = this.toDTO(dataSet);
            dataSetDTOList.add(returnDTO);
        }
        return dataSetDTOList;
    }

    @Override
    protected Class<?> getLogClass() {
        return BrandConverter.class;
    }


}
