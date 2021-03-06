// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/
// 

class Solution {
    public boolean validPalindrome(String s) {
     int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }
        if (i >= j) return true;
       return (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) ;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            }
            else return false;
        }
        return true;
    }
}

