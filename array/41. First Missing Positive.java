/*
41. First Missing Positive

Difficulty:Hard

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.


*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
    //if (nums[i]-1 != i && nums[nums[i]-1] != nums[i])不用那么多条件就可以了。  
    //因为只要是已经到位了的元素即：nums[i]-1==i了，那么判断如果有重复元素  
    //两个位置交换就最好考虑好两个位置出现的可能情况。考虑问题全面，两个条件都考虑好。  
    //update:增加i!=nums[i]表示i位置没到位，nums[nums[i]-1] != nums[i]表示nums[i]-1位置没到位，两个位置都判断也很好的。  
     if (nums == null) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i+1)) {
                int tmp = nums[nums[i]-1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
        }

        return nums.length + 1;
    }

   
    
}