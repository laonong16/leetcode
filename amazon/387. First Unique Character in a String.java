/*
387. First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if(map.containsKey(ch)) {
        //         map.put(ch, -1);
        //     } else {
        //         map.put(ch, i);
        //     }
        // }
        // int index = -1;
        // for(char ch : s.toCharArray()) {
        //     if(map.get(ch) != -1) {
        //         index = map.get(ch);
        //         break;
        //     }
        // }
        // return index;
        int[] indexs = new int[26];
        for(char ch : s.toCharArray()) {
            indexs[ch-'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
            if(indexs[ch-'a'] == 1) {
               return i ;
            }    
        }
        return -1;
    }
}

