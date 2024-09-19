import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalDemo {

    //isPresent()
    public static void check1(Optional<String> optional) {
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Empty message");
        }
    }

    //ifPresentOrElse
    public static void check2(Optional<String> optional) {
        optional.ifPresentOrElse(
                val -> System.out.println("There is a message: " + val),
                () -> System.out.println("There is no message.")
        );
    }

    //orElse(), orElseGet()
    public static void check3(Optional<String> optional) {
        String str = optional.orElse("Empty");
        System.out.println("This is the result from orElse() call: " + str);
    }

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("Hello world");
        Optional<String> optional2 = Optional.empty();
        String s1 = null;
        String s2 = "A non-null string";
        Optional<String> optional3 = Optional.ofNullable(s1);
        Optional<String> optional4 = Optional.ofNullable(s2);


        //isPresent()
        check1(optional1);
        check1(optional2);
        check1(optional3);
        check1(optional4);

        //ifPresentOrElse();
        check2(optional1);
        check2(optional2);

        //orElse()
        check3(optional1);
        check3(optional2);

    }
}
