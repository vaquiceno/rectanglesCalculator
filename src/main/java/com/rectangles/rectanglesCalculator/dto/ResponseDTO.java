package com.rectangles.rectanglesCalculator.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseDTO)) return false;
        ResponseDTO that = (ResponseDTO) o;
        return state == that.state && Objects.equals(desc, that.desc);
    }

}
