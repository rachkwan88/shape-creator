package com.example;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ShapeCreator creator = new ShapeCreator();
        try {
            creator.run();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
