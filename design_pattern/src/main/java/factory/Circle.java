package factory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("A circular shape object is drawn.");
    }

    @Override
    public void paint() {
        System.out.println("It is painted in blue color. ");
    }

}
