// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Reverse String
// https://leetcode.com/problems/reverse-string/
// 

class Solution {
    public String reverseString(String s) {
        if (s ==null || s.length() < 2) {
            return s;
        }
        int left =0;
        int right = s.length() - 1;
        char[] strArr = s.toCharArray();
        while (left < right) {
            char temp = strArr[left];
            strArr[left++] = strArr[right];
            strArr[right--] = temp;
        
        }
        return new String(strArr);
    }
}
