package com.rectangles.rectanglesCalculator.controller;

import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.http.RectangleDTO;
import com.rectangles.rectanglesCalculator.model.Rectangle;
import com.rectangles.rectanglesCalculator.service.RectangleService;
import com.rectangles.rectanglesCalculator.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rectangles")
public class RectangleController {

    @Autowired
    RectangleService rectangleService;

    @PostMapping("/containment")
    public ResponseEntity containment(@RequestBody List<RectangleDTO> rectangleDTOList){
        Utils.checkRectanglePoints(rectangleDTOList);
        List<Rectangle> rectangles = Utils.convertRectangles(rectangleDTOList);
        rectangles.stream().forEach(e-> System.out.println(e.getP1()));
        ContainmentDTO containmentDTO = rectangleService.containment(rectangles);
        return new ResponseEntity(containmentDTO, HttpStatus.OK);
    }

}
