/*
242. Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // if(s.length() != t.length()) {
        //     return false;
        // }
        // Map<Character, Integer> mapS = new HashMap<>();
        // Map<Character, Integer> mapT = new HashMap<>();
        // for(char ch : s.toCharArray()) {
        //    mapS.put(ch, mapS.getOrDefault(ch,new Integer(0)) + 1);
        // }
        // for(char ch : t.toCharArray()) {
        //    mapT.put(ch, mapT.getOrDefault(ch,new Integer(0)) + 1);
        // }
        // if(!mapS.keySet().containsAll(mapT.keySet()) 
        //    || !mapT.keySet().containsAll(mapS.keySet()) ) {
        //     return false;
        // } 
        // for(Character ch : mapS.keySet()){
        //     if(mapS.get(ch) != mapT.get(ch)) {
        //         return false;
        //     }
        // }
        // return true;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}