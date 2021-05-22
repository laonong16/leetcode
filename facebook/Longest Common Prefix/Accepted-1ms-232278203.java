// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/
// 

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = "";
        for (int i = 1; i < strs.length; i++) {
            if (prefix != "") 
                prefix = commonPrefix(prefix,strs[i]);
            else {
                prefix = commonPrefix(strs[i-1],strs[i]);
            }
           if (prefix == "") {
               return "";
           }
        }
        return prefix;
    }
   private String commonPrefix(String st1, String st2) {
        if (st1 == null || st1.length() == 0 || st2 == null || st2.length() ==0) {
            return "";
        }
        if (st1 == "" || st2 == "") {
            return "";
        }
        int ind1 = 0, ind2 = 0;
        while (ind1 < st1.length() && ind2 < st2.length()) {
            if (st1.charAt(ind1) == st2.charAt(ind2)) {
                ind1++;
                ind2++;
            } else {
                break;
            }
        }
        if (ind1 == 0) {
            return "";
        }
        return st1.substring(0,ind1);
    }
}
