package com.rectangles.rectanglesCalculator.dto;

public class ContainmentDTO {
    private boolean state;
    private String desc;

    public ContainmentDTO(boolean state, String desc) {
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
