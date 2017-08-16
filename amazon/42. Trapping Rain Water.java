// 42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

// thought : caculate left bar and  right bar for every spot, the water contain is  min(left,right) -  height, if it is >0

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int[] leftbar = new int[len];
        leftbar[0] = 0;
        for(int i = 1; i < len; i++){
            leftbar[i] = Math.max(leftbar[i-1], height[i-1]);
        }
        int[] rightbar = new int[len];
        rightbar[len-1] = 0;
        for(int j = len -2; j>=0;j--) {
            rightbar[j] = Math.max(rightbar[j+1],height[j+1]);
        }
        int total = 0;
        for(int i = 0 ; i < len; i++){
            int bar = Math.min(leftbar[i],rightbar[i]);
            if(bar > height[i]) {
                total+=bar - height[i];
            }
        }
        return total;
    }
}
