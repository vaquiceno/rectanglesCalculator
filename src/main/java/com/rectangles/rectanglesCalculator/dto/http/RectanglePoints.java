package com.rectangles.rectanglesCalculator.dto.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rectangles.rectanglesCalculator.model.Point;

public class RectanglePoints {
    @JsonProperty("p1")
    private Point p1;

    @JsonProperty("p2")
    private Point p2;

    @JsonProperty("p3")
    private Point p3;

    @JsonProperty("p4")
    private Point p4;

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

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }
}
