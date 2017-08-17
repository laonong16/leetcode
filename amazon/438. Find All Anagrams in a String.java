/*
438. Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() ==0
           || p ==null || p.length() == 0
           || s.length() < p.length()) {
            return result;
        }
        int lenp = p.length();
        int[] arrP = new int[26];
        for(char ch: p.toCharArray()) {
            arrP[ch-'a']++;
        }
        for(int i =0; i <= s.length() -lenp; i++) {
            String sub = s.substring(i,i+lenp);
            if(isAnagram(sub,arrP)) {
                result.add(i);
            }
        }
        return result;
    }
    public boolean isAnagram(String st, int[] arr) {
       int[] sArr = new int[26];
       for(char ch:st.toCharArray()) {
           sArr[ch-'a']++; 
       }
       for(int i = 0; i < 26; i++) {
            if(arr[i] != sArr[i]) {
                return false;
            } 
       }
        return true;
    }
}