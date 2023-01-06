package com.dguerrar.zara.controllers.exception.advices;

import com.dguerrar.zara.Constants.Constants;
import com.dguerrar.zara.exceptions.InvalidQueryException;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * null pointer excetion on Runtime
 *
 *
 *
 */

@ControllerAdvice
public class ExceptionControllerAdviceInvalid extends GenericModule {
    /**
     *
     */
    private static final long serialVersionUID = 4684103515995236919L;



    @ExceptionHandler({InvalidQueryException.class})
    public ResponseEntity exceptionHandler(InvalidQueryException ex) {
        log.error("fOUND ExceptionControllerAdviceRuntime" , ex);
        log.error("exception type: " + ex.getClass());
        List<String> recipients= new ArrayList<>();

        return new ResponseEntity(Constants.INVALID_DATA_FORMAT, HttpStatus.UNPROCESSABLE_ENTITY);//422
    }

    @Override
    protected Class<?> getLogClass() {
        return ExceptionControllerAdviceInvalid.class;
    }
}
