package com.rectangles.rectanglesCalculator.dto;

import com.rectangles.rectanglesCalculator.model.Point;

import java.util.List;

public class IntersectionDTO {
    private boolean state;
    private String desc;
    private List<Point> intersectionPoints;

    public IntersectionDTO(boolean state, String desc, List<Point> intersectionPoints) {
        this.state = state;
        this.desc = desc;
        this.intersectionPoints = intersectionPoints;
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

    public List<Point> getIntersectionPoints() {
        return intersectionPoints;
    }

    public void setIntersectionPoints(List<Point> intersectionPoints) {
        this.intersectionPoints = intersectionPoints;
    }

}
