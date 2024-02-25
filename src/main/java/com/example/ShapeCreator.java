package com.example;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeCreator {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Shape createCircle(double radius) {
        CircleShape shape = new CircleShape(radius);
        shapes.add(shape);
        return shape;
    }

    public Shape createRect(double length, double width) {
        RectangleShape shape = new RectangleShape(length,width);
        shapes.add(shape);
        return shape;
    }

    public void listShapes() {
        for (Shape shape : shapes) {
            System.out.println(shape.info());
        }
    }

    public void run() {

        System.out.println("Welcome to ShapeCreator! For more info, type help");

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {

            String command = scan.nextLine();
            System.out.print(command);
            if (command.equals("help")){
                System.out.println("Commands you can use: create_circle/list/create_rect");
            }
            else if (command.equals("create_circle")) {
                System.out.println("Enter an integer: ");
                double radius = Double.parseDouble(scan.nextLine());
                Shape shape = this.createCircle(radius);
                System.out.println("Circle created." + shape.info());
            }
            else if (command.equals("list")){
                this.listShapes();
            }
            else if (command.equals("create_rect")) {
                System.out.println("Enter the length: ");
                double length = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the width: ");
                double width = Double.parseDouble(scan.nextLine());
                Shape shape = this.createRect(length, width);
                System.out.println("Rectangle created." + shape.info());

            }
            else if (command.equals("quit")){
                System.exit(0);
            }
            else {
                System.out.println("BAD COMMAND, type help");
            }
        }
    }
}
