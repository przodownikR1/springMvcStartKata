package org.java.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ResultResponse handleBadRequestException(BadRequestException ex) {
        List<InputFieldError> inputFieldErrors = getInputFieldErrors(ex.getResult().getFieldErrors());
        return new ResultResponse(HttpStatus.BAD_REQUEST,inputFieldErrors);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ResultResponse handleRecordNotFoundException(RecordNotFoundException ex) {
        return new ResultResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * Extract field name and default message from BindingResult's FieldErrors object. We only need
     * these fields to be returned to the client.
     *
     * @param fieldErrors   List of field errors from BindingResult
     * @return      List of InputFieldErrors which contain field name and a default message
     */
    public List<InputFieldError> getInputFieldErrors(List<FieldError> fieldErrors) {
        if(fieldErrors == null || fieldErrors.size() < 1) return null;
        List<InputFieldError> inputFieldErrors = new ArrayList<>();
        for(FieldError fieldError: fieldErrors) {
            inputFieldErrors.add(new InputFieldError(fieldError.getField(),fieldError.getDefaultMessage()));
        }
        return inputFieldErrors;
    }
}
