package com.dguerrar.zara.controllers.exception.advices;

import com.dguerrar.zara.Constants.Constants;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * error when passing from JSON to class on springboot
 *
 */

@ControllerAdvice
public class ExceptionControllerAdviceNotFound extends GenericModule {


    /**
     *
     */
    private static final long serialVersionUID = 1772395021354429794L;


    @ExceptionHandler(	{JpaObjectRetrievalFailureException.class,java.util.NoSuchElementException.class})
    public ResponseEntity exceptionHandler(Exception ex) {
        log.error("fOUND ExceptionControllerAdviceBinding:" , ex);
        log.error("exception type: " + ex.getClass());

        return new ResponseEntity(Constants.ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);//404

    }

    @Override
    protected Class<?> getLogClass() {
        return ExceptionControllerAdviceNotFound.class;
    }
}
