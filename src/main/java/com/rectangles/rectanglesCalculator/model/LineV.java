package com.rectangles.rectanglesCalculator.model;

public class LineV {
   private Integer y1;
   private Integer y2;
   private Integer x;

    public LineV(Integer y1, Integer y2, Integer x) {
        this.y1 = y1;
        this.y2 = y2;
        this.x = x;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }
}
