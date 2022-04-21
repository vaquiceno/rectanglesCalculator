package com.rectangles.rectanglesCalculator.dto;

public class AdjacencyDTO extends ResponseDTO{

    private String type;

    public AdjacencyDTO(boolean state, String desc, String type) {
        super(state, desc);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
