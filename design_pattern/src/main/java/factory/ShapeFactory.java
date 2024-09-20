package factory;

import java.util.Optional;

public class ShapeFactory {
    public ShapeFactory(){}

    // call this method to create object of concrete shape class
    public Optional<Shape> createShape(String name) {
        Optional<Shape> shape;

        if (name.equalsIgnoreCase("square")) {
             shape = Optional.of(new Square());
        } else if (name.equalsIgnoreCase("circle")) {
            shape = Optional.of(new Circle());
        } else {
            shape = Optional.empty();
        }
        return shape;
    }
}
