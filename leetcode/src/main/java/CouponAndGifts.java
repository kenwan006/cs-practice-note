import java.util.PriorityQueue;

/**
 * Given a list of gifts, each num represent the coupons needed to get this gift
 * If there are n gifts, first gift can be bought (n-1) times, second can be bought (n-2)times, last one can be bought once
 * The max number of gifts to buy using k coupons
 *
 */

public class CouponAndGifts {
    public static int solve(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((i, j) -> arr[i] - arr[j]);
        for (int i = 0; i < n; i++) {
            heap.offer(i);
        }

        //greedy - every time try to buy the gift priced with the smallest coupons
        int res = 0;
        while (k > 0) {
            int idx = heap.poll();
            int value = arr[idx];

            if (k < value) break; //break if we can't even buy one gift

            int buy = Math.min(n - 1 - idx, k / value); // max buy is n - 1 - idx
            k -= value * buy;
            res += buy;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 8};
        int k = 10; //output 3
        System.out.println(solve(arr, k));
    }
}
