package com.rectangles.rectanglesCalculator.service.impl;

import com.rectangles.rectanglesCalculator.Constant.RectangleConstant;
import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.http.RectanglePoints;
import com.rectangles.rectanglesCalculator.service.RectangleService;
import com.rectangles.rectanglesCalculator.util.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RectangleServiceImpl implements RectangleService {
    @Override
    public ContainmentDTO containment(List<RectanglePoints> rectanglePointsList) {
        rectanglePointsList.stream().forEach(e -> System.out.println(e.getP1().getX()));
        Utils.checkRectanglePoints(rectanglePointsList);
        return new ContainmentDTO(RectangleConstant.CONTAINMENT.isState(), RectangleConstant.CONTAINMENT.getDesc());
    }
}
