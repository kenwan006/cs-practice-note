package factory;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main {
    public static void call(String name) {
        /**
         * we don't directly create the shape class, but let the shape factory to decide which concrete shape class to
         * create based on the input name.
         * It is very flexible because it allows us to creat the class dynamically
         */

        ShapeFactory factory = new ShapeFactory();
        Optional<Shape> optional = factory.createShape(name);
        optional.ifPresentOrElse(
                val -> {
                    val.draw();
                    val.paint();
                },
                () -> System.out.println("No shape found")
        );
    }
    public static void main(String[] args) {
        call("circle");
        call("square");
        call("triangle");
    }
}
