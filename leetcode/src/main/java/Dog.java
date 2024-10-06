public class Dog implements Animal{
    private String name;
    public Dog(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " is running");
    }

    public static void main(String[] args) {
        Animal dog = new Dog("Husky");
        dog.run(); //overridden method
        dog.eat("meat"); //default method of interface
        Animal.eat(100); // static method of interface
        System.out.println("This is Animal's food: " + Animal.getFood());
    }

}
