package com.rectangles.rectanglesCalculator.service;

import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.http.RectangleDTO;
import com.rectangles.rectanglesCalculator.model.Rectangle;

import java.util.List;

public interface RectangleService {
    //check if Rectangle A is wholly contained within Rectangle B
    ContainmentDTO containment(List<Rectangle> rectangles);
}
