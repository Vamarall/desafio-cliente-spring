package com.example.demo.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessages> fieldMessages = new ArrayList<>();

    public ValidationError(Instant timeStamp, Integer status, String error, String path) {
        super(timeStamp, status, error, path);
    }

    public List<FieldMessages> getFieldMessages() {
        return fieldMessages;
    }

    public void addFieldMessage(String fieldName, String message) {
        fieldMessages.add(new FieldMessages(fieldName, message));
    }

   
    
}