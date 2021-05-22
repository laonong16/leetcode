// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Sort Colors
// https://leetcode.com/problems/sort-colors/
// 

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int lastZ = -1;
        int firstT = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]== 0) {
                lastZ++;
               
            } else if (nums[i] == 2) {
                firstT--;
              
            }
            
        }
        for (int j = 0;  j < nums.length; j++) {
           if (j <= lastZ) {
               nums[j] = 0;
           } else if(j >= firstT) {
               nums[j] = 2;
           } else {
               nums[j] = 1;
           }
        }
    }
}
