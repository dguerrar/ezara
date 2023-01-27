package com.dguerrar.zara.converters.product;

import com.dguerrar.zara.controllers.price.PriceEntryController;
import com.dguerrar.zara.controllers.product.ProductController;
import com.dguerrar.zara.domain.Product;

import com.dguerrar.zara.dto.ProductDTO;
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
public class ProductConverter extends GenericModule implements GenericConverter<Product, ProductDTO> {


    public ProductDTO toDTO(Product product) throws Exception {
        if (product == null){
            return null;
        }
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product,dto);
        Link selfLink = linkTo(methodOn(ProductController.class)
                .getProductById(product.getId())).withSelfRel();
        dto.add(selfLink);

        return dto;
    }


    public Product toEntity(ProductDTO dto){
        if(dto == null ){
            return null;
        }
        Product product = new Product();
        BeanUtils.copyProperties(dto,product,this.getNullPropertyNames(dto));
        return product;
    }


    @Override
    public List<ProductDTO> toDTOList(List<Product> list) throws Exception {
        List<ProductDTO> dataSetDTOList= new ArrayList<>();

        for (Product dataSet: list) {
            ProductDTO returnDTO = this.toDTO(dataSet);
            dataSetDTOList.add(returnDTO);
        }
        return dataSetDTOList;
    }

    @Override
    protected Class<?> getLogClass() {
        return ProductConverter.class;
    }
}
