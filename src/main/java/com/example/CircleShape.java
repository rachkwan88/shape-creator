package com.example;

public class CircleShape implements Shape {

    public double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    //extend shapes
    public double area() {
        return Math.PI* Math.pow(radius,2);
    } 
    
    public String info(){
        return "Circle: radius= " + radius;
    }

}
