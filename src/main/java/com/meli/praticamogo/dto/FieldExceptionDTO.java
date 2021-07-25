package com.meli.praticamogo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class FieldExceptionDTO {
    @JsonProperty("ValidationError")
    private Map<String, String> validationErrors;

    public FieldExceptionDTO(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
