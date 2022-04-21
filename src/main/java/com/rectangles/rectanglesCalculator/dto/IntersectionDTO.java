package com.rectangles.rectanglesCalculator.dto;

import com.rectangles.rectanglesCalculator.model.Point;

import java.util.List;
import java.util.Objects;

public class IntersectionDTO extends ResponseDTO {

    private List<Point> intersectionPoints;

    public IntersectionDTO(boolean state, String desc, List<Point> intersectionPoints) {
        super(state, desc);
        this.intersectionPoints = intersectionPoints;
    }

    public List<Point> getIntersectionPoints() {
        return intersectionPoints;
    }

    public void setIntersectionPoints(List<Point> intersectionPoints) {
        this.intersectionPoints = intersectionPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntersectionDTO)) return false;
        if (!super.equals(o)) return false;
        IntersectionDTO that = (IntersectionDTO) o;
        return Objects.equals(intersectionPoints, that.intersectionPoints);
    }

}
