package com.dguerrar.zara.managers.tariff;


import com.dguerrar.zara.converters.tariff.TariffConverter;

import com.dguerrar.zara.domain.Tariff;

import com.dguerrar.zara.dto.TariffDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.repositories.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffManager extends GenericModule {

    @Autowired
    private TariffRepository tariffRepository;
    
    @Autowired
    private TariffConverter converter;

    public List<TariffDTO> geAllTariffs(){
        return converter.toDTOList(tariffRepository.findAll());
    }


    public TariffDTO getTariffById(Long id){

        Optional<Tariff> entryOptional= tariffRepository.findById(id);

        return converter.toDTO(entryOptional.get());
    }

    @Override
    protected Class<?> getLogClass() {
        return TariffManager.class;
    }
}
