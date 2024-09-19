import java.util.Arrays;

/**
 * Given an int array, need to return the max product of 5 nums from the array
 */

public class MaxKProduct {
    //max product of k numbers
    public static long solve(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        long res = 1l;
        int sign = 1;

        Arrays.sort(nums);

        //if k is odd, then the max num always has to be chosen
        if (k % 2 == 1) {
            res = nums[r];
            r--;
            k--;
            if (res < 0) sign = -1;
        }

        // now k is even, we can choose a pair of nums every time, either from left or right
        while (l < r) {
            long r_prod = nums[r] * nums[r - 1];
            long l_prod = nums[l] * nums[l + 1];
            if (r_prod * sign > l_prod * sign) {
                res *= r_prod;
                r -= 2;
            } else {
                res *= l_prod;
                l += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -6, -5, 1, 2, 5}; // 600
        int[] nums2 = {-10, -8, -5, -2, 4, 3}; // 3200
        int[] nums3 = {-10, -2, -3, -4, -5, -20}; // -1200;
        long ans = solve(nums, 5);
        long ans2 = solve(nums2, 5);
        long ans3 = solve(nums3, 5);

        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
