package com.dguerrar.zara.converters.brand;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.generic.GenericConverter;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandConverter extends GenericModule implements GenericConverter<Brand,BrandDTO> {


    public BrandDTO toDTO(Brand brand){
        if (brand == null){
            return null;
        }
        BrandDTO dto = new BrandDTO();
        BeanUtils.copyProperties(brand,dto);

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


    public List<BrandDTO> toDTOList(List<Brand> brands) {
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
