/*
416. Partition Equal Subset Sum
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

*/

public class Solution {
	 //Time exceed limited but  good solution for  Subsets
    boolean existing = false;
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        Arrays.sort(nums);
        helper (nums, 0, new ArrayList<Integer>(),total);
        return existing;
    }
    public void helper(int[] nums, int start, List<Integer> list,int total) {
        if(existing) {
            return;
        }
        if(list.size()>0) {
            int sum = sumofList(list);
            if(total == sum * 2) {
                existing = true;
                return;
            }
          }
        for(int i = start; i < nums.length; i++) {
            if(i!=start && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i+1, list, total);
            list.remove(list.size()-1);
        }
    }
    public int sumofList(List<Integer> list) {
        int sum = 0;
        for(int  num : list) {
            sum+=num;
        }
        return sum;
    }
    

// DP solution

    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[volumn];
    }
}