import java.util.Arrays;
import java.util.List;

/**
 * Given a list of integer, we have to split it into two groups.
 * Find the min difference of sum between two groups
 */
public class MinDiffOfTwoGroup {
    public static int solve(List<Integer> list) {
        //knapsack 0-1 problem
        //check if we can choose m numbers from the list whose sum equals to total_sum / 2;
        //if not, then check total_sum / 2 - 1
        int n = list.size();
        int sum = 0;
        for (int num : list) sum += num;

        boolean[][] dp = new boolean[n + 1][sum/2 + 1]; //dp[i][j] - we can use the nums from list[0, i] to fit the bag with volume j

        //if volume is 0, then we can always fit the bag
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum/2; j++) {
                //not choose ith num
                dp[i][j] = dp[i - 1][j];
                //choose ith num
                int curr = list.get(i - 1); //1-indexed
                if (j >= curr) dp[i][j] = dp[i][j] || dp[i - 1][j - curr];
            }
        }

        //we can compress the above 2d array to 1d for the optimization

        //find the max volume we can fit using nums from the list
        int min_diff = Integer.MAX_VALUE;
        for (int j = 1; j <= sum/2; j++) {
            if (dp[n][j]) {
                int group1 = j;
                int group2 = sum  - j;
                min_diff = Math.min(min_diff, group2 - group1);
            }
        }
        return min_diff;

    }
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 4); //1
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4); //0
        List<Integer> list3 = Arrays.asList(1, 2, 3, 8); //2
        System.out.println(solve(list1));
        System.out.println(solve(list2));
        System.out.println(solve(list3));
    }
}
