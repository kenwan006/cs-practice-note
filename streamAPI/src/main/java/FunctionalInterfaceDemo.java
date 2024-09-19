import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {

    //two custom functional interface as below
    interface Greeting {
        public void say(String name);
    }

    interface Calculator {
        public int calculate(int x);
    }

    public static void main(String[] args) {
        //some built in functional interface
        //Predicate - test()
        Predicate<Integer> predicate = x -> x % 2 == 0;
        int x = 10;
        boolean res1 = predicate.test(x);
        System.out.println("Predicate checks if x = " + x + " is even: " + res1);

        //Comparator - compare()
        Comparator<Integer> comparator = (a, b) -> a - b;
        int a = 1, b = 2;
        int res2 = comparator.compare(a, b);
        System.out.println("Comparator compares two items: " + a + " " + b + ", the result is: " + res2);

        //Consumer - accept()
        //tack an argument and perform an action but without returning result
        Consumer<String> consumer = (s) -> System.out.println("I have consumed a message: " + s);
        String s = "Hello world";
        consumer.accept(s);

        //Supplier - get()
        //generate or supply some values without any input
        Supplier<Integer> supplier = () -> new Random().nextInt(0, 100);
        int res3 = supplier.get();
        System.out.println("The supplier generate a value: " + res3);


        //custom functional interface
        Greeting greeting = (str) -> System.out.println("Custom greeting say, Hello my name is " + str);
        greeting.say("Ken");

        Calculator calculator = (num) -> (num + 1) * 100;
        int num = 100;
        int res4 = calculator.calculate(num);
        System.out.println("Custom calculator operate on num: " + num + ", and get the result: " + res4);

    }
}
