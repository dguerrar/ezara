package com.dguerrar.zara.converters.price;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.domain.Tariff;
import com.dguerrar.zara.domain.Product;
import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.generic.GenericConverter;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceEntryConverter extends GenericModule implements GenericConverter<PriceEntry, PriceEntryDTO> {


    public PriceEntryDTO toDTO(PriceEntry entry){
        if (entry == null){
            return null;
        }
        PriceEntryDTO dto = new PriceEntryDTO();
        BeanUtils.copyProperties(entry,dto);

        //set many to one entities
        dto.setBrandId(entry.getBrand().getId());
        dto.setTariffId(entry.getTariff().getId());
        dto.setProductId(entry.getProduct().getId());


        return dto;
    }


    public PriceEntry toEntity(PriceEntryDTO dto){
        if(dto == null ){
            return null;
        }
        PriceEntry entry = new PriceEntry();
        BeanUtils.copyProperties(dto,entry,this.getNullPropertyNames(dto));

        //set many to one entities
        Brand brand= new Brand();
        brand.setId(dto.getBrandId());
        entry.setBrand(brand);

        Product product = new Product();
        product.setId(dto.getProductId());
        entry.setProduct(product);

        Tariff ple= new Tariff();
        ple.setId(dto.getTariffId());
        entry.setTariff(ple);


        return entry;
    }


    public List<PriceEntryDTO> toDTOList(List<PriceEntry> entries) {
        List<PriceEntryDTO> dataSetDTOList= new ArrayList<>();

        for (PriceEntry dataSet: entries) {
            PriceEntryDTO returnDTO = this.toDTO(dataSet);
            dataSetDTOList.add(returnDTO);
        }
        return dataSetDTOList;
    }

    @Override
    protected Class<?> getLogClass() {
        return PriceEntryConverter.class;
    }


}
