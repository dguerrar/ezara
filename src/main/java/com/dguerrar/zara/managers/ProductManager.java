package com.dguerrar.zara.managers;

import com.dguerrar.zara.converters.ProductConverter;
import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.Product;
import com.dguerrar.zara.dto.ProductDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.repositories.BrandRepository;
import com.dguerrar.zara.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager extends GenericModule {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter converter;

    public List<ProductDTO> geAllProducts(){
        return converter.toDTOList(productRepository.findAll());
    }

    @Override
    protected Class<?> getLogClass() {
        return ProductManager.class;
    }
}
