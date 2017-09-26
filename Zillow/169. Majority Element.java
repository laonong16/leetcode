169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int result = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] == result) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    result= nums[i];
                    count++;
                }
            }
        }
        return result;
    }
}