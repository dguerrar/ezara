package com.dguerrar.zara.managers.price.validators;

import com.dguerrar.zara.dto.QueryDTO;
import com.dguerrar.zara.exceptions.InvalidQueryException;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.stereotype.Component;

@Component
public class PriceEntryValidator extends GenericModule {


    public void validate(QueryDTO dto ) throws Exception{

        if (null==dto){ throw new InvalidQueryException("Error");};
        if (null==dto.getDate()){ throw new InvalidQueryException("Error");};
        if (null==dto.getBrandId()){ throw new InvalidQueryException("Error");};
        if (null==dto.getProductId()){ throw new InvalidQueryException("Error");};


    }


    @Override
    protected Class<?> getLogClass() {
        return PriceEntryValidator.class;
    }
}
