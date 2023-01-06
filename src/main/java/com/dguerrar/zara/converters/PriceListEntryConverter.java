package com.dguerrar.zara.converters;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.PriceListEntry;
import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.dto.PriceListEntryDTO;
import com.dguerrar.zara.generic.GenericConverter;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceListEntryConverter extends GenericModule implements GenericConverter<PriceListEntry, PriceListEntryDTO> {


    public PriceListEntryDTO toDTO(PriceListEntry price){
        if (price == null){
            return null;
        }
        PriceListEntryDTO dto = new PriceListEntryDTO();
        BeanUtils.copyProperties(price,dto);

        return dto;
    }


    public PriceListEntry toEntity(PriceListEntryDTO dto){
        if(dto == null ){
            return null;
        }
        PriceListEntry price = new PriceListEntry();
        BeanUtils.copyProperties(dto,price,this.getNullPropertyNames(dto));
        return price;
    }



    @Override
    public List<PriceListEntryDTO> toDTOList(List<PriceListEntry> list) {
        List<PriceListEntryDTO> dataSetDTOList= new ArrayList<>();

        for (PriceListEntry dataSet: list) {
            PriceListEntryDTO returnDTO = this.toDTO(dataSet);
            dataSetDTOList.add(returnDTO);
        }
        return dataSetDTOList;
    }

    @Override
    protected Class<?> getLogClass() {
        return PriceListEntryConverter.class;
    }

}
