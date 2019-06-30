// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Target Sum
// https://leetcode.com/problems/target-sum/
// 

 /**
     * bug - 2;
     * <p>
     * Sum - 2 * A = Target; there are some numbers subtracted from the Sum, and that part should be A here.
     * <p>
     * Sum - A: not adding the part; Sum - 2 * A furthermore, we subtract the sum by A, which is equal to Target.
     * <p>
     * Sum - A = Target + A = (Sum + Target) / 2, so we are  actually solving the 0-1 Knapsack problem while target is
     * Target + A.
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int n : nums) sum += n;
            if (Math.abs(target) > Math.abs(sum) || (target + sum) % 2 == 1) return 0;
            target = (target + sum) / 2;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = target; j >= nums[i]; --j) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[target];
        }
    }

