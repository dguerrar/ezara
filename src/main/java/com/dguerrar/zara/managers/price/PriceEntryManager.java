package com.dguerrar.zara.managers.price;

import com.dguerrar.zara.converters.price.PriceEntryConverter;
import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.dto.QueryDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.price.validators.PriceEntryValidator;
import com.dguerrar.zara.repositories.PriceEntryRepository;
import com.dguerrar.zara.repositories.specifications.PriceEntryFinderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



    public List<PriceEntry>  getPriceEntryByQuerygrapQL(QueryDTO queryDTO) throws Exception {

        validator.validate(queryDTO);

        Pageable pageable = PageRequest.of(0, 1,Sort.by("priority").descending());

        Page<PriceEntry>  priceEntryFirst= priceEntryRepository.findAll(priceEntryFinderSpecification.findBetweenDates(queryDTO.getDate())
                        .and(priceEntryFinderSpecification.findOnBrand(queryDTO.getBrandId()))
                        .and (priceEntryFinderSpecification.findOnProduct(queryDTO.getProductId())
                                .and(priceEntryFinderSpecification.findOntariff(queryDTO.getTariffId()))),
                pageable
        );


        return priceEntryFirst.toList();

    }


    public List<PriceEntryDTO>  getPriceEntryByQuery(QueryDTO queryDTO) throws Exception {

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
