package com;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.RectangleShape;

/**
 * Unit test for simple App.
 */
public class RectangleShapeTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAreaFuncs() {

        RectangleShape rectangle1 = new RectangleShape(4, 7);
        assertTrue(rectangle1.area() == 28);

        RectangleShape rectangle2 = new RectangleShape(2, 6);
        assertTrue(rectangle2.area() == 12);

    }
}
