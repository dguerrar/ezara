package com.dguerrar.zara.managers;

import com.dguerrar.zara.converters.BrandConverter;
import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager extends GenericModule {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandConverter converter;

    public List<BrandDTO> geAllBrands(){
        return converter.toDTOList(brandRepository.findAll());
    }

    @Override
    protected Class<?> getLogClass() {
        return BrandManager.class;
    }
}
