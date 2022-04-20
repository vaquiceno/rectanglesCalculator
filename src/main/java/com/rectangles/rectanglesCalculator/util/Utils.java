package com.rectangles.rectanglesCalculator.util;

import com.rectangles.rectanglesCalculator.dto.http.RectanglePoints;
import com.rectangles.rectanglesCalculator.exception.ValidationException;

import java.util.List;

public class Utils {
    private final static int LIST_SIZE = 2;
    public static void checkRectanglePoints(List<RectanglePoints> rectanglePointsList){
        if (rectanglePointsList.size() != LIST_SIZE)
            throw new ValidationException("List must have two Rectangles");

    }
}
