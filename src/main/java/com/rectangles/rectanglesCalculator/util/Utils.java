package com.rectangles.rectanglesCalculator.util;

import com.rectangles.rectanglesCalculator.Constant.RectangleConstant;
import com.rectangles.rectanglesCalculator.dto.http.RectangleDTO;
import com.rectangles.rectanglesCalculator.exception.ValidationException;
import com.rectangles.rectanglesCalculator.model.LineH;
import com.rectangles.rectanglesCalculator.model.LineV;
import com.rectangles.rectanglesCalculator.model.Point;
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

    public static Point intersectionPoint(LineH lineH, LineV lineV){
        if (lineV.getX() > lineH.getX1()
            && lineV.getX() < lineH.getX2()
            && lineH.getY() < lineV.getY1()
            && lineH.getY() > lineV.getY2()){
            return new Point(lineV.getX(), lineH.getY());
        }
        return null;
    }

    public static RectangleConstant adjacencyLinesH(LineH lineA, LineH lineB){
        RectangleConstant adjacencyRes = RectangleConstant.NO_ADJACENCY;
        if (lineA.getY() == lineB.getY()){
            // check sub-line adjacency in both directions
            if ((lineA.getX1() > lineB.getX1() && lineA.getX2() < lineB.getX2())
                || (lineB.getX1() > lineA.getX1() && lineB.getX2() < lineA.getX2())){
                adjacencyRes = RectangleConstant.SUBLINE_ADJACENCY;
            }
            // check proper adjacency
            else if (lineA.getX1() == lineB.getX1() && lineA.getX2() == lineB.getX2()){
                adjacencyRes = RectangleConstant.PROPER_ADJACENCY;
            }
            // else is partial adjacency
            else {
                adjacencyRes = RectangleConstant.PARTIAL_ADJACENCY;
            }
        }
        return adjacencyRes;
    }

    public static RectangleConstant adjacencyLinesV(LineV lineA, LineV lineB){
        RectangleConstant adjacencyRes = RectangleConstant.NO_ADJACENCY;
        if (lineA.getX() == lineB.getX()){
            // check sub-line adjacency in both directions
            if ((lineA.getY1() < lineB.getY1() && lineA.getY2() > lineB.getY2())
                    || (lineB.getY1() < lineA.getY1() && lineB.getY2() > lineA.getY2())){
                adjacencyRes = RectangleConstant.SUBLINE_ADJACENCY;
            }
            // check proper adjacency
            else if (lineA.getY1() == lineB.getY1() && lineA.getY2() == lineB.getY2()){
                adjacencyRes = RectangleConstant.PROPER_ADJACENCY;
            }
            // else is partial adjacency
            else {
                adjacencyRes = RectangleConstant.PARTIAL_ADJACENCY;
            }
        }
        return adjacencyRes;
    }
}
