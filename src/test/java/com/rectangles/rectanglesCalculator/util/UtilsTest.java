package com.rectangles.rectanglesCalculator.util;

import com.rectangles.rectanglesCalculator.Constant.RectangleConstant;
import com.rectangles.rectanglesCalculator.dto.http.RectangleDTO;
import com.rectangles.rectanglesCalculator.exception.ValidationException;
import com.rectangles.rectanglesCalculator.model.LineH;
import com.rectangles.rectanglesCalculator.model.LineV;
import com.rectangles.rectanglesCalculator.model.Point;

import com.rectangles.rectanglesCalculator.model.Rectangle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UtilsTest {

    private static final Point P1 = new Point(4, 5);
    private static final Point P2 = new Point(8, 1);
    private static final RectangleDTO RECTANGLE_DTO_1 = new RectangleDTO(P1, P2);
    private static final Rectangle RECTANGLE_1 = new Rectangle(P1, P2);

    private static final Point P3 = new Point(5, 4);
    private static final Point P4 = new Point(7, 2);
    private static final RectangleDTO RECTANGLE_DTO_2 = new RectangleDTO(P3, P4);
    private static final Rectangle RECTANGLE_2 = new Rectangle(P3, P4);

    private static final Point P5 = new Point(null, 4);
    private static final Point P6 = new Point(7, null);
    private static final RectangleDTO RECTANGLE_DTO_3 = new RectangleDTO(P5, P6);

    private static final RectangleDTO RECTANGLE_DTO_4 = new RectangleDTO(P6, P5);

    private static final RectangleDTO RECTANGLE_DTO_5 = new RectangleDTO(null, null);

    private static final RectangleDTO RECTANGLE_DTO_6 = new RectangleDTO(P1, P6);

    private static final RectangleDTO RECTANGLE_DTO_7 = new RectangleDTO(P1, P5);

    private static final RectangleDTO RECTANGLE_DTO_8 = new RectangleDTO(P1, null);

    private static final RectangleDTO RECTANGLE_DTO_9 = new RectangleDTO(P2, P1);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_1 = Arrays.asList(RECTANGLE_DTO_1);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_2 = Arrays.asList(RECTANGLE_DTO_1, RECTANGLE_DTO_2);

    private static final List<Rectangle> RECTANGLE_LIST = Arrays.asList(RECTANGLE_1, RECTANGLE_2);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_3 = Arrays.asList(RECTANGLE_DTO_3, RECTANGLE_DTO_5);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_4 = Arrays.asList(RECTANGLE_DTO_4, RECTANGLE_DTO_5);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_5 = Arrays.asList(RECTANGLE_DTO_6, RECTANGLE_DTO_5);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_6 = Arrays.asList(RECTANGLE_DTO_7, RECTANGLE_DTO_5);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_7 = Arrays.asList(RECTANGLE_DTO_5, RECTANGLE_DTO_5);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_8 = Arrays.asList(RECTANGLE_DTO_8, RECTANGLE_DTO_5);

    private static final List<RectangleDTO> RECTANGLE_DTO_LIST_9 = Arrays.asList(RECTANGLE_DTO_9, RECTANGLE_DTO_1);

    private static final LineH LINE_H = new LineH(1,3, 5);

    private static final LineH LINE_H2 = new LineH(1,3, 9);

    private static final LineV LINE_V = new LineV(7, 2, 2);

    private static final Point INTERSECTION_POINT = new Point(2,5);

    private static final LineH LINE_H_SUB = new LineH(-1, 4, 5);

    private static final LineH LINE_H_PART = new LineH(-1, 2, 5);

    private static final LineV LINE_V_SUB = new LineV(6, 3, 2);

    private static final LineV LINE_V_PART = new LineV(6, 1, 2);

    @Test
    public void checkRectanglePoints() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_2);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException1() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_1);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException2() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_3);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException3() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_4);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException4() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_5);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException5() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_6);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException6() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_7);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException7() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_8);
    }

    @Test(expected = ValidationException.class)
    public void checkRectanglePointsException8() {
        Utils.checkRectanglePoints(RECTANGLE_DTO_LIST_9);
    }

    @Test
    public void convertRectangles() {
        assertEquals(Utils.convertRectangles(RECTANGLE_DTO_LIST_2), RECTANGLE_LIST);
    }

    @Test(expected = ValidationException.class)
    public void convertRectanglesException1() {
        assertEquals(Utils.convertRectangles(RECTANGLE_DTO_LIST_1), null);
    }

    @Test
    public void intersectionPoint() {
        assertEquals(Utils.intersectionPoint(LINE_H, LINE_V), INTERSECTION_POINT);
    }

    @Test
    public void intersectionPoint2() {
        assertEquals(Utils.intersectionPoint(LINE_H2, LINE_V), null);
    }

    @Test
    public void adjacencyLinesH1() {
        assertEquals(Utils.adjacencyLinesH(LINE_H_SUB, LINE_H), RectangleConstant.SUBLINE_ADJACENCY);
    }

    @Test
    public void adjacencyLinesH2() {
        assertEquals(Utils.adjacencyLinesH(LINE_H, LINE_H), RectangleConstant.PROPER_ADJACENCY);
    }

    @Test
    public void adjacencyLinesH3() {
        assertEquals(Utils.adjacencyLinesH(LINE_H, LINE_H_PART), RectangleConstant.PARTIAL_ADJACENCY);
    }

    @Test
    public void adjacencyLinesV1() {
        assertEquals(Utils.adjacencyLinesV(LINE_V_SUB, LINE_V), RectangleConstant.SUBLINE_ADJACENCY);
    }

    @Test
    public void adjacencyLinesV2() {
        assertEquals(Utils.adjacencyLinesV(LINE_V, LINE_V), RectangleConstant.PROPER_ADJACENCY);
    }

    @Test
    public void adjacencyLinesV3() {
        assertEquals(Utils.adjacencyLinesV(LINE_V, LINE_V_PART), RectangleConstant.PARTIAL_ADJACENCY);
    }

}