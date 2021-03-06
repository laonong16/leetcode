// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Two Sum
// https://leetcode.com/problems/two-sum/
// 

class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] result = new int[]{-1,-1};
        if (nums == null || nums.length <= 1) {
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

