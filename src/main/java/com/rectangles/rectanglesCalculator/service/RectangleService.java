package com.rectangles.rectanglesCalculator.service;

import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.IntersectionDTO;
import com.rectangles.rectanglesCalculator.model.Rectangle;


public interface RectangleService {
    //check if Rectangle A is wholly contained within Rectangle B
    ContainmentDTO containment(Rectangle A, Rectangle B);
    //check if Rectangles have one or more
    //intersecting lines and produce a result identifying the points of intersection
    IntersectionDTO intersection(Rectangle A, Rectangle B);
}
