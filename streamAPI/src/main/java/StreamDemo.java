import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 2, 1, 3, 6, 1};
        String[] strs = {"Abcd", "bcde", "Ddedf", "Eed", "awefergeg"};
        Employee mike = new Employee(1, "mike", 20, Arrays.asList("123-456-789", "123-456-788", "123-456-787"));
        Employee bob = new Employee(2, "bob", 21, Arrays.asList("123-456-786", "123-456-785"));
        Employee ken = new Employee(1, "ken", 22, Arrays.asList("123-456-784", "123-456-783"));
        List<Employee> employees = Arrays.asList(mike, bob, ken);

        // filter()
        //output a list of even number
        List<Integer> list1 = Arrays.stream(nums)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Output the even numbers: " + list1);
        System.out.println("Output each number at each line:  ");
        list1.forEach(System.out::println);

        // map()
        //double each even number
        List<Integer> list2 = Arrays.stream(nums)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Output the doubled even number: " + list2);

        //change each string to Uppercase string
        List<String> list22 = Arrays.stream(strs)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Output the a list of uppercase strings: " + list22);

        // sorted()
        //sort the nums
        List<Integer> list3 = Arrays.stream(nums)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Output the sorted list of nums: " + list3);

        // distinct()
        // output the distinct nums
        List<Integer> list4 = Arrays.stream(nums)
                .distinct()
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Output the distinct numbers: " + list4);

        // max(), min(), skip()
        //find the second greatest number
        int largest_num = Arrays.stream(nums)
                .boxed()
                .max((a, b) -> a.compareTo(b))//no need to convert integer to int because of auto unboxing
                .orElse(Integer.MIN_VALUE);

        int second_largest = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> b.compareTo(a))
                .skip(1) //skip the largest
                .findFirst()
                .orElse(0);

        String longest_str = Arrays.stream(strs)
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("The largest num is: " + largest_num);
        System.out.println("The second largest num is: " + second_largest);
        System.out.println("The longest string is: " + longest_str);

        // flatMap()
        //get all phone number
        List<String> list5 = employees.stream()
                .flatMap(emp -> emp.getNumbers().stream())
                .collect(Collectors.toList());

        System.out.println("Phone number of all employees: " + list5);

        // toMap()
        //map each name of employee to their age
        Map<String, Integer> map1 = employees.stream()
                .collect(Collectors.toMap(emp -> emp.getName(), emp -> emp.getAge()));

        System.out.println("Output the age for each name of employee: " + map1);

        // groupingBy + counting
        //count (long type) the frequency of each num in the array and generate a hashmap mapping num -> freq
        Map<Integer, Long> map2 = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println("Output the frequency for each num: " + map2);

    }
}
