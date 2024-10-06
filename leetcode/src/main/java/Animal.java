public interface Animal {
    static final String food = "grass";

    void run();

    static void eat(int weight) {
        System.out.println("Animal is eating " + food + "with the weight " + weight);
    }

    default void eat(String food) {
        System.out.println("Hello I am eating a different food " + food);
    }

    static String getFood() {
        return food;
    }
}
