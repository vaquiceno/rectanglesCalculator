package com.rectangles.rectanglesCalculator.dto.error;

public class ResponseErrorDTO {
    private String error;

    public ResponseErrorDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
