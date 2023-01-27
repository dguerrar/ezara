package com.dguerrar.zara.managers.brand;

import com.dguerrar.zara.converters.brand.BrandConverter;
import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.dto.BrandDTO;
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

    public List<BrandDTO> geAllBrands() throws Exception {
        return converter.toDTOList(brandRepository.findAll());
    }


    public BrandDTO getBrandById(Long id) throws Exception {

        Optional<Brand> entryOptional= brandRepository.findById(id);

        return converter.toDTO(entryOptional.get());
    }


    @Override
    protected Class<?> getLogClass() {
        return BrandManager.class;
    }
}
