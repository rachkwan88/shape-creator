package com.example;

public class RectangleShape extends Shape {

    private double width;
    private double length;

    public RectangleShape(double width, double length) {
        this.width = width;
        this.length = length;
    }

    //extend shapes
    public double area() {
        return width * length;
    } 

    public String info(){
        return "Rectangle: width="+width+" length: "+length;
    }

}
