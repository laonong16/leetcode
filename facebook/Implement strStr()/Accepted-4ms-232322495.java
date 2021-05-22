// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Implement strStr()
// https://leetcode.com/problems/implement-strstr/
// 

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int i = 0; // haystack pointer
        int j = 0; // needle pointer
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
            i++;
            if (j >= needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }
}
