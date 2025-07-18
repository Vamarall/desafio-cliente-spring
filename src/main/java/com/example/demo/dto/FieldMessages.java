package com.example.demo.dto;

public class FieldMessages {
    private String fieldName;
    private String message;

    public FieldMessages(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
