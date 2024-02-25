package com.example;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class ShapeCreator {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Shape createCircle(double radius) {
        CircleShape shape = new CircleShape(radius);
        shapes.add(shape);
        return shape;
    }

    public Shape createRect(double length, double width) {
        RectangleShape shape = new RectangleShape(length, width);
        shapes.add(shape);
        return shape;
    }

    public void doListShapes() {
        if (shapes.size() == 0) {
            System.out.println("No shapes");
        }
        for (Shape shape : shapes) {
            System.out.println(shape.info());
        }
    }

    public void doHelp() {
        System.out.println("Commands you can use: create_circle/list/create_rect");
    }

    public void doCreateCircle(Scanner scan) {
        System.out.println("Enter an integer: ");
        double radius = Double.parseDouble(scan.nextLine());
        Shape shape = this.createCircle(radius);
        System.out.println("Circle created." + shape.info());
    }

    public void doCreateRect(Scanner scan) {
        System.out.println("Enter the length: ");
        double length = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the width: ");
        double width = Double.parseDouble(scan.nextLine());
        Shape shape = this.createRect(length, width);
        System.out.println("Rectangle created." + shape.info());
    }

    public void doSave() throws IOException {
        String fileName = "shapes.txt";
        BufferedWriter out = null;
        File file = new File(fileName);
        FileWriter fstream;
        
        if (file.exists()) {
            fstream = new FileWriter(fileName, false);// if file exists append to file. Works fine.
        } else {
            file.createNewFile();
            fstream = new FileWriter(file);
        }
        out = new BufferedWriter(fstream);

        for (Shape shape : shapes) {
            if (shape instanceof CircleShape) {
                out.write("circle," + ((CircleShape) shape).radius + "\n");
            } else if (shape instanceof RectangleShape) {
                out.write("rectangle," + ((RectangleShape) shape).length + "," + ((RectangleShape) shape).width + "\n");
            }
        }

        if (out != null) {
            out.close();
        }
    }

    public void doLoad() throws IOException {
        BufferedReader reader;

        ArrayList<Shape> tempShapes = new ArrayList<Shape>();

        reader = new BufferedReader(new FileReader("shapes.txt"));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }

            String tokens[] = line.split(",");
            if (tokens[0].equals("circle")) {
                CircleShape circle = new CircleShape(Double.parseDouble(tokens[1]));
                tempShapes.add(circle);
            } else if (tokens[0].equals("rectangle")) {
                RectangleShape rectangle = new RectangleShape(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]));
                tempShapes.add(rectangle);
            }

        }

        shapes = tempShapes;

        reader.close();
    }

    public void run() throws IOException {

        System.out.println("Welcome to ShapeCreator! For more info, type help");

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {

            String command = scan.nextLine();
            // System.out.print(command);
            if (command.equals("help")) {
                this.doHelp();
            } else if (command.equals("create_circle")) {
                this.doCreateCircle(scan);
            } else if (command.equals("list")) {
                this.doListShapes();
            } else if (command.equals("create_rect")) {
                this.doCreateRect(scan);
            } else if (command.equals("quit")) {
                System.exit(0);
            } else if (command.equals("save")) {
                this.doSave();
            } else if (command.equals("load")) {
                this.doLoad();
            } else {
                System.out.println("BAD COMMAND, type help");
            }
        }
        scan.close();
    }
}
