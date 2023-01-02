package com.dguerrar.zara.managers;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.Product;
import com.dguerrar.zara.repositories.BrandRepository;
import com.dguerrar.zara.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> geAllProducts(){
        return productRepository.findAll();
    }

}
