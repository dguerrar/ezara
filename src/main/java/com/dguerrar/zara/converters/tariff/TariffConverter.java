package com.dguerrar.zara.converters.tariff;

import com.dguerrar.zara.controllers.product.ProductController;
import com.dguerrar.zara.controllers.tariff.TariffController;
import com.dguerrar.zara.domain.Tariff;
import com.dguerrar.zara.dto.TariffDTO;
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
public class TariffConverter extends GenericModule implements GenericConverter<Tariff, TariffDTO> {


    public TariffDTO toDTO(Tariff tariff) throws Exception {
        if (tariff == null){
            return null;
        }
        TariffDTO dto = new TariffDTO();
        BeanUtils.copyProperties(tariff,dto);


        Link selfLink = linkTo(methodOn(TariffController.class)
                .getTarriffById(tariff.getId())).withSelfRel();
        dto.add(selfLink);
        return dto;
    }


    public Tariff toEntity(TariffDTO dto){
        if(dto == null ){
            return null;
        }
        Tariff price = new Tariff();
        BeanUtils.copyProperties(dto,price,this.getNullPropertyNames(dto));
        return price;
    }



    @Override
    public List<TariffDTO> toDTOList(List<Tariff> list) throws Exception {
        List<TariffDTO> dataSetDTOList= new ArrayList<>();

        for (Tariff dataSet: list) {
            TariffDTO returnDTO = this.toDTO(dataSet);
            dataSetDTOList.add(returnDTO);
        }
        return dataSetDTOList;
    }

    @Override
    protected Class<?> getLogClass() {
        return TariffConverter.class;
    }

}
