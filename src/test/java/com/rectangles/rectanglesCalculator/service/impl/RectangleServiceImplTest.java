package com.rectangles.rectanglesCalculator.service.impl;

import com.rectangles.rectanglesCalculator.Constant.RectangleConstant;
import com.rectangles.rectanglesCalculator.dto.AdjacencyDTO;
import com.rectangles.rectanglesCalculator.dto.ContainmentDTO;
import com.rectangles.rectanglesCalculator.dto.IntersectionDTO;
import com.rectangles.rectanglesCalculator.model.Point;
import com.rectangles.rectanglesCalculator.model.Rectangle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RectangleServiceImplTest {
    @InjectMocks
    private RectangleServiceImpl rectangleService;

    private static final Point P1 = new Point(4, 5);
    private static final Point P2 = new Point(8, 1);
    private static final Rectangle RECTANGLE_1 = new Rectangle(P1, P2);

    private static final Point P3 = new Point(5, 4);
    private static final Point P4 = new Point(7, 2);
    private static final Rectangle RECTANGLE_2 = new Rectangle(P3, P4);

    private static final Point P5 = new Point(1, 11);
    private static final Point P6 = new Point(5, 6);
    private static final Rectangle RECTANGLE_3 = new Rectangle(P5, P6);

    private static final Point P7 = new Point(3, 13);
    private static final Point P8 = new Point(7, 9);
    private static final Rectangle RECTANGLE_4 = new Rectangle(P7, P8);

    private static final Point P9 = new Point(-1, 7);
    private static final Point P10 = new Point(2, 2);
    private static final Rectangle RECTANGLE_5 = new Rectangle(P9, P10);

    private static final Point P11 = new Point(3, 7);
    private static final Point P12 = new Point(7, 2);
    private static final Rectangle RECTANGLE_6 = new Rectangle(P11, P12);

    private static final Point P13 = new Point(5, 11);
    private static final Point P14 = new Point(10, 6);
    private static final Rectangle RECTANGLE_7 = new Rectangle(P13, P14);

    private static final Point P15 = new Point(1, 16);
    private static final Point P16 = new Point(5, 11);
    private static final Rectangle RECTANGLE_8 = new Rectangle(P15, P16);

    private static final Point INTERSECTION_POINT_1 = new Point(3,11);

    private static final Point INTERSECTION_POINT_2 = new Point(5,9);

    private static final Point INTERSECTION_POINT_3 = new Point(2, 6);

    private static final Point INTERSECTION_POINT_4 = new Point(1, 7);

    private static final Point INTERSECTION_POINT_5 = new Point(3, 6);

    private static final Point INTERSECTION_POINT_6 = new Point(5, 7);

    private static final List<Point> POINT_LIST_1 = Arrays.asList(INTERSECTION_POINT_1, INTERSECTION_POINT_2);

    private static final List<Point> POINT_LIST_2 = Arrays.asList(INTERSECTION_POINT_3, INTERSECTION_POINT_4);

    private static final List<Point> POINT_LIST_3 = Arrays.asList(INTERSECTION_POINT_5, INTERSECTION_POINT_6);

    private static final List<Point> POINT_LIST_4 = Arrays.asList(INTERSECTION_POINT_6, INTERSECTION_POINT_5);

    private static final ContainmentDTO CONTAINMENT_DTO = new ContainmentDTO(RectangleConstant.CONTAINMENT.isState(), RectangleConstant.CONTAINMENT.getDesc());

    private static final IntersectionDTO INTERSECTION_DTO_1 = new IntersectionDTO(RectangleConstant.INTERSECTION.isState(), RectangleConstant.INTERSECTION.getDesc(), POINT_LIST_1);

    private static final IntersectionDTO INTERSECTION_DTO_2 = new IntersectionDTO(RectangleConstant.INTERSECTION.isState(), RectangleConstant.INTERSECTION.getDesc(), POINT_LIST_2);

    private static final IntersectionDTO INTERSECTION_DTO_3 = new IntersectionDTO(RectangleConstant.INTERSECTION.isState(), RectangleConstant.INTERSECTION.getDesc(), POINT_LIST_3);

    private static final IntersectionDTO INTERSECTION_DTO_4 = new IntersectionDTO(RectangleConstant.INTERSECTION.isState(), RectangleConstant.INTERSECTION.getDesc(), POINT_LIST_4);

    private static final AdjacencyDTO ADJACENCY_DTO_1 = new AdjacencyDTO(RectangleConstant.PROPER_ADJACENCY.isState(), RectangleConstant.PROPER_ADJACENCY.getDesc(), RectangleConstant.PROPER_ADJACENCY.toString());

    @Test
    public void containment() {
        assertEquals(rectangleService.containment(RECTANGLE_1, RECTANGLE_2), CONTAINMENT_DTO);
    }

    @Test
    public void intersection() {
        assertEquals(rectangleService.intersection(RECTANGLE_3, RECTANGLE_4), INTERSECTION_DTO_1);
        assertEquals(rectangleService.intersection(RECTANGLE_3, RECTANGLE_5), INTERSECTION_DTO_2);
        assertEquals(rectangleService.intersection(RECTANGLE_3, RECTANGLE_6), INTERSECTION_DTO_3);
        assertEquals(rectangleService.intersection(RECTANGLE_6, RECTANGLE_3), INTERSECTION_DTO_4);
    }

    @Test
    public void adjacency() {
        assertEquals(rectangleService.adjacency(RECTANGLE_3, RECTANGLE_7), ADJACENCY_DTO_1);
        assertEquals(rectangleService.adjacency(RECTANGLE_7, RECTANGLE_3), ADJACENCY_DTO_1);
        assertEquals(rectangleService.adjacency(RECTANGLE_3, RECTANGLE_8), ADJACENCY_DTO_1);
        assertEquals(rectangleService.adjacency(RECTANGLE_8, RECTANGLE_3), ADJACENCY_DTO_1);
    }

}