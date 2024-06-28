package CreationalDP_SPFAB;

// The Prototype Design Pattern is a creational pattern that enables the creation of new objects
//  by copying an existing object. Prototype allows us to hide the
//   complexity of making new instances from the client. 
//   The concept is to copy an existing object rather than create a new instance from scratch,
//    something that may include costly operations. 
//    The existing object acts as a prototype and contains the state of the object.

// Prototype interface
interface Shape {
    Shape clone(); // Make a copy of itself

    void draw(); // Draw the shape
}

// Concrete prototype
class Circle implements Shape {
    private String color;

    // When you create a circle, you give it a color.
    public Circle(String color) {
        this.color = color;
    }

    // This creates a copy of the circle.
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    // This is how a circle draws itself.
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

// Client code
class ShapeClient {
    private Shape shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using the prototype.
    public Shape createShape() {
        return shapePrototype.clone();
    }
}

// Main class
public class Prototype {
    public static void main(String[] args) {
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");

        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);

        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();

        // Draw the newly created red circle.
        redCircle.draw();
    }
}
