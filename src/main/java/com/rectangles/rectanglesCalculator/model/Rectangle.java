package com.rectangles.rectanglesCalculator.model;

import java.util.Objects;

public class Rectangle {
    private Point p1;
    private Point p2;

    public Rectangle(Point p1, Point p2) {
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

    public LineH getLineUp() {
        return new LineH(p1.getX(), p2.getX(), p1.getY());
    }

    public LineH getLineDown() {
        return new LineH(p1.getX(), p2.getX(), p2.getY());
    }

    public LineV getLineLeft() {
        return new LineV(p1.getY(), p2.getY(), p1.getX());
    }

    public LineV getLineRight() {
        return new LineV(p1.getY(), p2.getY(), p2.getX());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(p1, rectangle.p1) && Objects.equals(p2, rectangle.p2);
    }
}
