package com.dguerrar.zara.managers;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListEntryManager {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> geAllBrands(){
        return brandRepository.findAll();
    }

}
