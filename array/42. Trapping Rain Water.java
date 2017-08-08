/*
42. Trapping Rain Water

Difficulty:Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


*/
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) { 
            return 0;
        }
        int len = height.length;
        int[] leftbar = new int[len];
        int[]  rightbar = new int[len];
        int leftmax = height[0];
        for(int i = 0; i < len; i++) {
            leftbar[i] = Math.max(height[i],leftmax);
            leftmax = leftbar[i];
        }
        int rightmax = height[len - 1];
        for(int i = len -1; i>=0; i--) {
            rightmax = Math.max(rightmax, height[i]);
            rightbar[i] = rightmax;
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            int cur = Math.min(leftbar[i],rightbar[i]) - height[i];
            sum += cur >0? cur:0;
        }
        return sum;
    }
}