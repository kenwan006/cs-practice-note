package prototype;

public class MyPrototype implements Prototype{
    private String name;
    private String city = "shanghai";

    public MyPrototype(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new MyPrototype(this.name);
    }
    @Override
    public String toString() {
        return "MyPrototype{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static void main(String[] args) {
        MyPrototype prototype = new MyPrototype("Ken");
        System.out.println(prototype);

        MyPrototype clonedObject = (MyPrototype) prototype.clone();
        clonedObject.setName("Kevin");
        System.out.println(clonedObject);
    }
}
