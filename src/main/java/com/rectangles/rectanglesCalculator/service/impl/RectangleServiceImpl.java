package com.rectangles.rectanglesCalculator.service.impl;

import com.rectangles.rectanglesCalculator.Constant.RectangleConstant;
import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.IntersectionDTO;
import com.rectangles.rectanglesCalculator.model.Point;
import com.rectangles.rectanglesCalculator.model.Rectangle;
import com.rectangles.rectanglesCalculator.service.RectangleService;
import com.rectangles.rectanglesCalculator.util.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RectangleServiceImpl implements RectangleService {
    @Override
    public ContainmentDTO containment(Rectangle A, Rectangle B) {
        RectangleConstant containmentRes = RectangleConstant.NO_CONTAINMENT;
        if (B.getP1().getX() > A.getP1().getX()
            && B.getP1().getY() < A.getP1().getY()
            && A.getP2().getX() > B.getP2().getX()
            && A.getP2().getY() < B.getP2().getY()){
            containmentRes = RectangleConstant.CONTAINMENT;
        }
        return new ContainmentDTO(containmentRes.isState(), containmentRes.getDesc());
    }

    @Override
    public IntersectionDTO intersection(Rectangle A, Rectangle B) {
        RectangleConstant intersectionRes = RectangleConstant.NO_INTERSECTION;
        List<Point> intersectionPointList = new ArrayList<>();
        Point intersectionPoint = null;
        //check for perpendicular lines between both rectangles:
        //A-LineUp and B-LineLeft
        intersectionPoint = Utils.intersectionPoint(A.getLineUp(), B.getLineLeft());
        if (intersectionPoint != null)
            intersectionPointList.add(intersectionPoint);
        //A-LineUp and B-LineRight
        intersectionPoint = Utils.intersectionPoint(A.getLineUp(), B.getLineRight());
        if (intersectionPoint != null)
            intersectionPointList.add(intersectionPoint);
        //A-LineDown and B-LineLeft
        intersectionPoint = Utils.intersectionPoint(A.getLineDown(), B.getLineLeft());
        if (intersectionPoint != null)
            intersectionPointList.add(intersectionPoint);
        //A-LineDown and B-LineRight
        intersectionPoint = Utils.intersectionPoint(A.getLineDown(), B.getLineRight());
        if (intersectionPoint != null)
            intersectionPointList.add(intersectionPoint);

        if (intersectionPointList.size() > 0){
            intersectionRes = RectangleConstant.INTERSECTION;
        }

        return new IntersectionDTO(intersectionRes.isState(), intersectionRes.getDesc(), intersectionPointList);
    }
}
