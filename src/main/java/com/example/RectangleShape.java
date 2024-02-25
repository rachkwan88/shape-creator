package com.example;

public class RectangleShape implements Shape {

    public double width;
    public double length;

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
