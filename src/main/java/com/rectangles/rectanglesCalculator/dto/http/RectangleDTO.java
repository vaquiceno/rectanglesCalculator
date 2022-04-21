package com.rectangles.rectanglesCalculator.dto.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rectangles.rectanglesCalculator.model.Point;

public class RectangleDTO {
    @JsonProperty("p1")
    private Point p1;

    @JsonProperty("p2")
    private Point p2;

    public RectangleDTO(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
