package com.dguerrar.zara.generic;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.dto.BrandDTO;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.List;
import java.util.stream.Stream;

public interface GenericConverter<T,E> {

    public <E> E toDTO(T t);
    public <T> T toEntity(E e);
    public List<E> toDTOList(List<T> t);

    public default  String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
