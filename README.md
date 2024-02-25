Design

classes needed: 

class Shape
class RectangleShape extends Shape
class CircleShape extends Shape


int x[] = {1, 2, 3, 1}; // an array of "int"
int y = 4
int z = 3
int x[]  = {x, y, x, y} 

// an array of Shape


Shape x[] = {RectangleShape, CircleShape}
CircleShape circle1 = new CircleShape(radius)
RectangleShape rectangle1 = new RectangleShape(length, width)
Shape shapes[] = {circle1, rectangle1}

for (int i=0, i<x.length(),i++){
    System.out.println(shapes[i].calculateArea())
}