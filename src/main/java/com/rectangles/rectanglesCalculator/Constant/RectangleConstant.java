package com.rectangles.rectanglesCalculator.Constant;

public enum RectangleConstant {
    INTERSECTION(true, "Rectangles have one or more intersecting lines"),
    NO_INTERSECTION(false, "Rectangles do not have intersecting lines"),
    CONTAINMENT(true, "Rectangle A is wholly contained within rectangle B"),
    NO_CONTAINMENT(false, "Rectangle A is not wholly contained within rectangle B"),
    PROPER_ADJACENCY(true, "There is proper adjacency in the Rectangles"),
    SUBLINE_ADJACENCY(true, "There is sub-line adjacency in the Rectangles"),
    PARTIAL_ADJACENCY(true, "There is partial adjacency in the Rectangles"),
    NO_ADJACENCY(false, "There is no adjacency in the Rectangles");

    private boolean state;
    private String desc;

    RectangleConstant(boolean state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public boolean isState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }
}
