package com.dguerrar.zara.controllers.exception.advices;

import com.dguerrar.zara.Constants.Constants;
import com.dguerrar.zara.generic.GenericModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * error when passing from JSON to class on springboot
 *
 */

@ControllerAdvice
public class ExceptionControllerAdviceBinding extends GenericModule {


    /**
     *
     */
    private static final long serialVersionUID = 1772395021354429794L;


    @ExceptionHandler(	{org.springframework.http.converter.HttpMessageNotReadableException.class})
    public ResponseEntity exceptionHandler(Exception ex) {
        log.error("fOUND ExceptionControllerAdviceBinding:" , ex);
        log.error("exception type: " + ex.getClass());

        return new ResponseEntity(Constants.ERROR_BAD_FORMAT, HttpStatus.BAD_REQUEST);//400

    }

    @Override
    protected Class<?> getLogClass() {
        return ExceptionControllerAdviceBinding.class;
    }
}
