package com.rectangles.rectanglesCalculator.service;

import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.model.Rectangle;


public interface RectangleService {
    //check if Rectangle A is wholly contained within Rectangle B
    ContainmentDTO containment(Rectangle A, Rectangle B);
}
