/*
1. Two Sum

Difficulty:Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Thoughts:

use a hashtable to store  <value, index> pair
traverse the  array  and the map to find out 
if there is   value in map for the element in array;
O(n), O(n)
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 1) {
            return new int[2];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
             if(map.containsKey(target - nums[i])) {
                 result[0] = map.get(target - nums[i]);
                 result[1] = i;
                 return result;
             }
             map.put(nums[i],i);
        }
        return result;
    }
}