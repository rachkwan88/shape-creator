package com;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.CircleShape;

/**
 * Unit test for simple App.
 */
public class CircleShapeTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testArea()
    {
        
        
        CircleShape circle1 = new CircleShape(4);
        double area1= Math.round(circle1.area()*100);
        assertTrue( area1/100 == 50.27);

        CircleShape circle2 = new CircleShape(3.6);
        double area2 = Math.round(circle2.area()*100);
        assertTrue( area2/100 == 40.72);

    }
}
