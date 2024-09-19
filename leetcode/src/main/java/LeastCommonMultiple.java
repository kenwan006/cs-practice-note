/**
 * given a list of pair, each pair has to nums, find the least common multiple for each pair
 * eg, LCM for pair[2, 3] is 6, LCM for pair[3, 6] is 6, LCM for pair [5, 7] is 35
 */

import java.util.Arrays;
public class LeastCommonMultiple {

    public static int[] solve(int[][] arr) {
        //we can easily observe the LCM for two nums - x and y is
        // x * y / (gcd(x, y))
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = arr[i][0], y = arr[i][1];
            res[i] = x * y / (gcd(x, y));
        }
        return res;
    }

    //greatest common divisor of x and y
    private static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        int[][] arr = {{12, 5}, {3, 6}, {17, 13}}; //output [60, 6, 221]
        Arrays.stream(solve(arr))
                .forEach(System.out::println);
    }
}
