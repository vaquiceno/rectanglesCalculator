package com.rectangles.rectanglesCalculator.model;

public class Rectangle {
    Line up;
    Line down;
    Line left;
    Line right;

    public Rectangle(Line up, Line down, Line left, Line right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public Line getUp() {
        return up;
    }

    public void setUp(Line up) {
        this.up = up;
    }

    public Line getDown() {
        return down;
    }

    public void setDown(Line down) {
        this.down = down;
    }

    public Line getLeft() {
        return left;
    }

    public void setLeft(Line left) {
        this.left = left;
    }

    public Line getRight() {
        return right;
    }

    public void setRight(Line right) {
        this.right = right;
    }

}
