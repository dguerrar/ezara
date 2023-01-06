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
 *
 * null pointer excetion on Runtime
 *
 *
 *
 */

@ControllerAdvice
public class ExceptionControllerAdviceRuntime extends GenericModule {
    /**
     *
     */
    private static final long serialVersionUID = 4684103515995236919L;



    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity exceptionHandler(NullPointerException ex) {
        log.error("fOUND ExceptionControllerAdviceRuntime" , ex);
        log.error("exception type: " + ex.getClass());
        List<String> recipients= new ArrayList<>();

        return new ResponseEntity(Constants.ERROR_UNDEFINED_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);//500
    }

    @Override
    protected Class<?> getLogClass() {
        return ExceptionControllerAdviceRuntime.class;
    }
}
