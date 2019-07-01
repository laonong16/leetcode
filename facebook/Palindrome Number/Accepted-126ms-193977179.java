// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Palindrome Number
// https://leetcode.com/problems/palindrome-number/
// 

class Solution {
    public boolean isPalindrome(int x) {
         if ( x < 0 ||((x!=0 && x%10==0))) {
            return false;
        }
        int reverse = 0;
        while(reverse < x) {
            reverse = reverse *10 + x % 10;
            x /= 10;
        }
        return reverse ==  x  || reverse /10 == x;
    }
}

