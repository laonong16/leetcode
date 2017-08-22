/*
5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        String result = s.substring(0,1);
        for(int i =0; i < s.length(); i++) {
           result = findPalindrome(s,i,i,result);
           result = findPalindrome(s,i,i+1,result);
        }
        return result;
    }
    public String findPalindrome(String s, int left, int right, String result) {
        while(left >=0 && right< s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(result.length() < (right - left)) {
            result = s.substring(left+1,right);
        }
        return result;
    }
}