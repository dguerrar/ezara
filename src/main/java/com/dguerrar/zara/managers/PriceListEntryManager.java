package com.dguerrar.zara.managers;


import com.dguerrar.zara.converters.PriceListEntryConverter;

import com.dguerrar.zara.domain.PriceListEntry;

import com.dguerrar.zara.dto.PriceListEntryDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.repositories.PriceListEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceListEntryManager extends GenericModule {

    @Autowired
    private PriceListEntryRepository priceListEntryRepository;
    
    @Autowired
    private PriceListEntryConverter converter;

    public List<PriceListEntryDTO> geAllPriceListEntry(){
        return converter.toDTOList(priceListEntryRepository.findAll());
    }


    public PriceListEntryDTO getPriceListEntryById(Long id){

        Optional<PriceListEntry> entryOptional= priceListEntryRepository.findById(id);

        return converter.toDTO(entryOptional.get());
    }

    @Override
    protected Class<?> getLogClass() {
        return PriceListEntryManager.class;
    }
}
