package com.dguerrar.zara.controllers.exception.advices;

import com.dguerrar.zara.Constants.Constants;
import com.dguerrar.zara.generic.GenericModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionControllerAdvicejsonIO  extends GenericModule {

    /**
     * this error will launch internally when using gson or jackson to parse from dto to json and viceversa
     */
    private static final long serialVersionUID = -1164764340424003247L;
    @ExceptionHandler({ JsonProcessingException.class,
            com.fasterxml.jackson.core.JsonParseException.class, IOException.class,com.fasterxml.jackson.databind.exc.InvalidFormatException.class })
    public ResponseEntity exceptionHandler(Exception ex) {
        log.error("fOUND ExceptionControllerAdvicejsonIO {}" , ex);
        log.error("fOUND ExceptionControllerAdvicejsonIO {}" , ex.getMessage());
        log.error("exception type: " + ex.getClass());
        return new ResponseEntity(Constants.INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);//500
    }

    @Override
    protected Class<?> getLogClass() {
        return ExceptionControllerAdvicejsonIO.class;
    }

}
