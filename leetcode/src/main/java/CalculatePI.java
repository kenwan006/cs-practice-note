import static java.lang.Math.PI;

public class CalculatePI {
    public static double calculate(long n) {
        double res = 0.0;
        for (int i = 1; i < n; i++) {
            res += 1.0 / (i * i);
        }
        res *= 6;

        double pi = Math.sqrt(res);
        return pi;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 10000, 100000, 1000000};
        for (int n : arr) {
            System.out.println("When n = " + n + ", the difference is: " + (calculate(n) - PI));
        }
    }
}
