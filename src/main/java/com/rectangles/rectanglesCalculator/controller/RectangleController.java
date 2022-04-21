package com.rectangles.rectanglesCalculator.controller;

import com.rectangles.rectanglesCalculator.dto.AdjacencyDTO;
import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.IntersectionDTO;
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
        Rectangle A = rectangles.get(0);
        Rectangle B = rectangles.get(1);
        ContainmentDTO containmentDTO = rectangleService.containment(A, B);
        return new ResponseEntity(containmentDTO, HttpStatus.OK);
    }

    @PostMapping("/intersection")
    public ResponseEntity intersection(@RequestBody List<RectangleDTO> rectangleDTOList){
        Utils.checkRectanglePoints(rectangleDTOList);
        List<Rectangle> rectangles = Utils.convertRectangles(rectangleDTOList);
        Rectangle A = rectangles.get(0);
        Rectangle B = rectangles.get(1);
        IntersectionDTO intersectionDTO = rectangleService.intersection(A, B);
        return new ResponseEntity(intersectionDTO, HttpStatus.OK);
    }

    @PostMapping("/adjacency")
    public ResponseEntity adjacency(@RequestBody List<RectangleDTO> rectangleDTOList){
        Utils.checkRectanglePoints(rectangleDTOList);
        List<Rectangle> rectangles = Utils.convertRectangles(rectangleDTOList);
        Rectangle A = rectangles.get(0);
        Rectangle B = rectangles.get(1);
        AdjacencyDTO adjacencyDTO = rectangleService.adjacency(A, B);
        return new ResponseEntity(adjacencyDTO, HttpStatus.OK);
    }

}
