package DesignPattern.StructuralDP;

//Implementor (Bridge) interface
interface DrawingAPI {
 void drawCircle(int radius, int x, int y);
 void drawSquare(int side, int x, int y);
}

//Concrete Implementors (Concrete Drawing Mechanisms)
class RedDrawing implements DrawingAPI {
 @Override
 public void drawCircle(int radius, int x, int y) {
     System.out.println("Drawing Red Circle with radius " + radius + " at (" + x + "," + y + ")");
 }

 @Override
 public void drawSquare(int side, int x, int y) {
     System.out.println("Drawing Red Square with side " + side + " at (" + x + "," + y + ")");
 }
}

class GreenDrawing implements DrawingAPI {
 @Override
 public void drawCircle(int radius, int x, int y) {
     System.out.println("Drawing Green Circle with radius " + radius + " at (" + x + "," + y + ")");
 }

 @Override
 public void drawSquare(int side, int x, int y) {
     System.out.println("Drawing Green Square with side " + side + " at (" + x + "," + y + ")");
 }
}
class BlueDrawing implements DrawingAPI {
@Override
public void drawCircle(int radius, int x, int y) {
    System.out.println("Drawing Blue Circle with radius " + radius + " at (" + x + "," + y + ")");
}

@Override
public void drawSquare(int side, int x, int y) {
    System.out.println("Drawing Blue Square with side " + side + " at (" + x + "," + y + ")");
}
	
}

//Abstraction
abstract class Shape {
 protected DrawingAPI drawingAPI;

 protected Shape(DrawingAPI drawingAPI) {
     this.drawingAPI = drawingAPI;
 }

 abstract void draw();
}

//Refined Abstraction (Circle)
class Circle extends Shape {
 private int radius;
 private int x;
 private int y;

 public Circle(int radius, int x, int y, DrawingAPI drawingAPI) {
     super(drawingAPI);
     this.radius = radius;
     this.x = x;
     this.y = y;
 }

 @Override
 void draw() {
     drawingAPI.drawCircle(radius, x, y);
 }
}

//Refined Abstraction (Square)
class Square extends Shape {
 private int side;
 private int x;
 private int y;

 public Square(int side, int x, int y, DrawingAPI drawingAPI) {
     super(drawingAPI);
     this.side = side;
     this.x = x;
     this.y = y;
 }

 @Override
 void draw() {
     drawingAPI.drawSquare(side, x, y);
 }
}

//Client Code
public class BridgeDp {
 public static void main(String[] args) {
     // Using Red Drawing Mechanism
     DrawingAPI redDrawing = new RedDrawing();
     Shape redCircle = new Circle(5, 10, 15, redDrawing);
     Shape redSquare = new Square(8, 20, 25, redDrawing);

     redCircle.draw();
     redSquare.draw();

     // Using Green Drawing Mechanism
     DrawingAPI greenDrawing = new GreenDrawing();
     Shape greenCircle = new Circle(7, 30, 35, greenDrawing);
     Shape greenSquare = new Square(10, 40, 45, greenDrawing);

     greenCircle.draw();
     greenSquare.draw();
     
     DrawingAPI blueDrawing = new BlueDrawing();
     Shape blueCircle = new Circle(6, 10, 8, blueDrawing);
     Shape blueSqure = new Square(7, 5, 3, blueDrawing);
     
     blueCircle.draw();
     blueSqure.draw();
 }
}

/*
    The DrawingAPI interface represents the bridge between the abstraction and its implementation, defining methods for drawing circles and squares.
    Concrete implementors (RedDrawing and GreenDrawing) provide specific drawing mechanisms.
    The Shape class is the abstraction that relies on the DrawingAPI.
    Refined abstractions (Circle and Square) extend the base Shape and implement the draw method using the specified drawing mechanism.
    */
