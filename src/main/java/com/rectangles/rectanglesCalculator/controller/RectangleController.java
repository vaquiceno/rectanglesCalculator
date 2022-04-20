package com.rectangles.rectanglesCalculator.controller;

import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.http.RectanglePoints;
import com.rectangles.rectanglesCalculator.service.RectangleService;
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
    public ResponseEntity containment(@RequestBody List<RectanglePoints> rectanglePointsList){
        ContainmentDTO containmentDTO = rectangleService.containment(rectanglePointsList);
        return new ResponseEntity(containmentDTO, HttpStatus.OK);
    }

}
