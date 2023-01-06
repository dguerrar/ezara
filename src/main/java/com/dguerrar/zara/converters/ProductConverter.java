package com.dguerrar.zara.converters;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.PriceListEntry;
import com.dguerrar.zara.domain.Product;

import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.dto.PriceListEntryDTO;
import com.dguerrar.zara.dto.ProductDTO;
import com.dguerrar.zara.generic.GenericConverter;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter extends GenericModule implements GenericConverter<Product, ProductDTO> {


    public ProductDTO toDTO(Product product){
        if (product == null){
            return null;
        }
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product,dto);

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
    public List<ProductDTO> toDTOList(List<Product> list) {
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
