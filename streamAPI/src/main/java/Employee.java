import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {
    int id;
    String name;
    int age;
    List<String> numbers;
    public Employee(int id, String name, int age, List<String> numbers) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.numbers = numbers;
    }
}
