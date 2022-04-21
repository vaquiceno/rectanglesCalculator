package com.rectangles.rectanglesCalculator.util;

import com.rectangles.rectanglesCalculator.dto.http.RectangleDTO;
import com.rectangles.rectanglesCalculator.exception.ValidationException;
import com.rectangles.rectanglesCalculator.model.Rectangle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {
    private final static int LIST_SIZE = 2;
    public static void checkRectanglePoints(List<RectangleDTO> rectangleDTOList){
        if (rectangleDTOList.size() != LIST_SIZE)
            throw new ValidationException("List must have two sets of two points (two Rectangles)");

        IntStream.range(0, rectangleDTOList.size())
                .forEach(index -> {
                    //validate data is complete
                    if (rectangleDTOList.get(index).getP1() == null)
                        throw new ValidationException("Rectangle number " + index + " do not have P1 point");
                    if (rectangleDTOList.get(index).getP2() == null)
                        throw new ValidationException("Rectangle number " + index + " do not have P2 point");

                    if (rectangleDTOList.get(index).getP1().getX() == null)
                        throw new ValidationException("Rectangle number " + index + " do not have X value in P1 point");
                    if (rectangleDTOList.get(index).getP1().getY() == null)
                        throw new ValidationException("Rectangle number " + index + " do not have Y value in P1 point");
                    if (rectangleDTOList.get(index).getP2().getX() == null)
                        throw new ValidationException("Rectangle number " + index + " do not have X value in P2 point");
                    if (rectangleDTOList.get(index).getP2().getY() == null)
                        throw new ValidationException("Rectangle number " + index + " do not have Y value in P2 point");

                    //validate each rectangle is well formed

                    if (rectangleDTOList.get(index).getP2().getX() <= rectangleDTOList.get(index).getP1().getX()
                        || rectangleDTOList.get(index).getP2().getY() >= rectangleDTOList.get(index).getP1().getY()){
                        throw new ValidationException("Rectangle number " + index + " is not well formed");
                    }

                });
    }

    public static List<Rectangle> convertRectangles(List<RectangleDTO> rectangleDTOList) {
        if (rectangleDTOList.size() != LIST_SIZE)
            throw new ValidationException("List must have two sets of two points (two Rectangles)");
        return rectangleDTOList.stream().map(r -> new Rectangle(r.getP1(), r.getP2())).collect(Collectors.toList());
    }
}
