package com.rectangles.rectanglesCalculator.service.impl;

import com.rectangles.rectanglesCalculator.Constant.RectangleConstant;
import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.model.Rectangle;
import com.rectangles.rectanglesCalculator.service.RectangleService;
import org.springframework.stereotype.Service;

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
}
