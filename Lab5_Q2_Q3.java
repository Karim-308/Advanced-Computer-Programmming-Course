package Q2;
import javafx.geometry.Point2D;
public abstract class Shape { 
private Point2D start;
/**
* Constructor to initallize the start point 
* @param start : Point2D
*/
public Shape(Point2D start) {
this.start = start; }
/**
* @return Point2D return the start
*/ 
public Point2D getStart() {
return start; }
/**
* @param start the start to set
*/ 
public void setStart(Point2D start) {
this.start = start; }
public abstract void draw(); }
//Line class:
package Q2;
import javafx.geometry.Point2D; 
public class Line extends Shape { 
private Point2D end;
/**
* costructor to initialize the start and the end of the line 
* @param start the start to initialize
* @param end the end to initialize 
*/
public Line(Point2D start, Point2D end) {
super(start);
this.end = end; }
/**
* @return Point2D return the end 
*/ 
public Point2D getEnd() { 
return end; } 
/**
* @param end the end to set 
*/ 
public void setEnd(Point2D end) {
this.end = end; }
/**
* To draw the line
*/ 
@Override public void draw() {
System.out.println("Drawing Line");
System.out.println("Start:" + super.getStart()); System.out.println("End:" + this.end); } }
//Rectangle class:
package Q2; 
import javafx.geometry.Point2D; 
public class Rectangle extends Shape {
private double length;
private double width;
/**
* constructor to initialize the Rectangle
* @param start the start of the rectangle 
* @param length the length of the rectangle
* @param width the width of the rectangle
*/
public Rectangle(Point2D start, double length, double width) { 
super(start);
this.length = length;
this.width = width; }
/**
* @return double return the length 
*/ public double getLength() {
return length; }
/**
* @param length the length to set
*/ 
public void setLength(double length) {
this.length = length; } 
/**
* @return double return the width 
*/
public double getWidth() {
return width; }
/**
* @param width the width to set
*/ public void setWidth(double width) {
this.width = width; }
/**
* to draw the rectangle
*/ 
@Override public void draw() {
System.out.println("drawing Rectangle");
System.out.println("Start:" + super.getStart());
System.out.println("Length: " + this.length); 
System.out.println("Width: " + this.width); } }
//Ellipse class:
package Q3; 
import Q2.*;
import javafx.geometry.Point2D;
public class TestQ3 { 
public static void main(String[] args) throws Exception { 
Canvas c = new Canvas();
Shape[] shapes = { new Line(new Point2D(0, 0), new Point2D(5, 5)), new Line(new Point2D(-
2, -2), new Point2D(5, 5)), new Line(new Point2D(-2, 0), new Point2D(0, 2)), new 
Rectangle(new Point2D(0, 0), 5, 5), new Rectangle(new Point2D(1, 1), 3, 2.5), new 
Rectangle(new Point2D(-1, 3), 2, 2), new Ellipse(new Point2D(0, 0), 5, 3.5), new Ellipse(new 
Point2D(2, 3), 3, 7), new Ellipse(new Point2D(10, 10), 3, 3.5), };
//to add new shapes to the canvas 
for (Shape s : shapes) { c.addShape(s); }
//check the remove method 
System.out.println(c.removeShape(shapes[0]));
// check getShape method 
c.getShape(new Point2D(2.5, 2.5)).draw();
//check draw all method 
c.drawAll(); 
}
}
//Canvas class:
package Q3;
import Q2.*; 
import java.util.ArrayList;
import javafx.geometry.Point2D; 
public class Canvas {
private ArrayList shapes;
/**
* constructor to create the Canvas 
*/
public Canvas() { 
shapes = new ArrayList(); } 
/**
* to add a new shape to the Canvas
* @param shape shape to add 
*/
public void addShape(Shape shape) {
this.shapes.add(shape); }
/**
* to remove a shape from the Canvas
* @param shape : shape to remove
* @return true if the shape was found and removed, false otherwise */
public boolean removeShape(Shape shape) {
for (Shape s : this.shapes) {
if (s.equals(shape)) {
this.shapes.remove(shape);
return true;
}
}
//if not found 
return false; }
/**
* to get shape that its start is the closest to the specified point 
* @param point : the specified point 
* @return the closest shape 
*/ 
public Shape getShape(Point2D x) {
double distance;
double minDistance = 0; 
Shape closestShape = null;
boolean c = false;
for (Shape s : this.shapes) { 
distance = x.distance(s.getStart());
if (!c) {
// for the first shape in the canvas
minDistance = distance;
c = true;
closestShape = s; }
if (distance < minDistance && c) { 
// to chaeck each other shape in the canvas
minDistance = distance; 
closestShape = s; }
}
return closestShape; }
/**
* to draw all the shapes in the Canvas 
*/ 
public void drawAll() {
int counter = 1;
for (Shape s : shapes) { 
System.out.println("------Shape no.:" + counter++); s.draw(); }
}
}
//Test code:
package Q3; 
import Q2.*; 
import javafx.geometry.Point2D; 
public class TestQ3 { 
public static void main(String[] args) throws Exception { 
Canvas c = new Canvas(); 
Shape[] shapes = { 
new Line(new Point2D(0, 0), new Point2D(5, 5)), 
new Line(new Point2D(-2, -2), new Point2D(5, 5)), 
new Line(new Point2D(-2, 0), new Point2D(0, 2)), 
new Rectangle(new Point2D(0, 0), 5, 5), 
new Rectangle(new Point2D(1, 1), 3, 2.5), 
new Rectangle(new Point2D(-1, 3), 2, 2), 
new Ellipse(new Point2D(0, 0), 5, 3.5), 
new Ellipse(new Point2D(2, 3), 3, 7), 
new Ellipse(new Point2D(10, 10), 3, 3.5), 
}; 
//to add new shapes to the canvas
for (Shape s : shapes) { 
c.addShape(s); 
} 
//check the remove method
System.out.println(c.removeShape(shapes[0])); 
// check getShape method
c.getShape(new Point2D(2.5, 2.5)).draw(); 
//check draw all method
c.drawAll(); 
} 
}