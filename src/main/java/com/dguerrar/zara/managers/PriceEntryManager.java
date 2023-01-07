package com.dguerrar.zara.managers;

import com.dguerrar.zara.converters.PriceEntryConverter;
import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.dto.QueryDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.validators.PriceEntryValidator;
import com.dguerrar.zara.repositories.PriceEntryRepository;
import com.dguerrar.zara.repositories.specifications.PriceEntryFinderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceEntryManager extends GenericModule {

    @Autowired
    private PriceEntryRepository priceEntryRepository;

    @Autowired
    private PriceEntryFinderSpecification priceEntryFinderSpecification;

    @Autowired
    private PriceEntryValidator validator;

    @Autowired
    private PriceEntryConverter converter;

    public List<PriceEntry> geAllPrices(){
        return priceEntryRepository.findAll();
    }

    public List<PriceEntryDTO>  getPriceEntryByDates(QueryDTO queryDTO) throws Exception {

        validator.validate(queryDTO);

        Pageable pageable = PageRequest.of(0, 1,Sort.by("priority").descending());

        Page<PriceEntry>  priceEntryFirst= priceEntryRepository.findAll(priceEntryFinderSpecification.findBetweenDates(queryDTO.getDate())
                .and(priceEntryFinderSpecification.findOnBrand(queryDTO.getBrandId()))
                .and (priceEntryFinderSpecification.findOnProduct(queryDTO.getProductId())),
                pageable
        );
        return converter.toDTOList(priceEntryFirst.toList());


    }


    public PriceEntryDTO getPriceEntryById(Long id){

        Optional<PriceEntry> entryOptional= priceEntryRepository.findById(id);

        return converter.toDTO(entryOptional.get());
    }

    @Override
    protected Class<?> getLogClass() {
        return PriceEntryManager.class;
    }
}
