package com.dguerrar.zara.managers;

import com.dguerrar.zara.converters.BrandConverter;
import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandManager extends GenericModule {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandConverter converter;

    public List<BrandDTO> geAllBrands(){
        return converter.toDTOList(brandRepository.findAll());
    }


    public BrandDTO getBrandById(Long id){

        Optional<Brand> entryOptional= brandRepository.findById(id);

        return converter.toDTO(entryOptional.get());
    }


    @Override
    protected Class<?> getLogClass() {
        return BrandManager.class;
    }
}
