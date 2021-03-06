// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Counting Bits
// https://leetcode.com/problems/counting-bits/
// 

class Solution {
    /*
    规律是，从1开始，遇到偶数时，其1的个数和该偶数除以2得到的数字的1的个数相同，遇到奇数时，其1的个数等于该奇数除以2得到的数字的1的个数再加1，
    */
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] nums = new int[num + 1];
        nums[1] = 1;
        for (int i = 2; i <=num; i++) {
            if (i%2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i/2] + 1;
            }
        }
        return nums;
    }
}

