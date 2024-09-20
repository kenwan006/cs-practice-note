package factory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("A squared shape object is drawn.");
    }

    @Override
    public void paint() {
        System.out.println("It is painted in red color.");
    }


}
