package com.rectangles.rectanglesCalculator.dto;

public class ResponseDTO {
    private boolean state;
    private String desc;

    public ResponseDTO(boolean state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
