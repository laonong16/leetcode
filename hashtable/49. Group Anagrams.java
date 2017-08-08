/*
49. Group Anagrams

Difficulty:Medium

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String st: strs) {
            char[] chs = st.toCharArray();
            Arrays.sort(chs);
            String key = new String (chs);
            if(map.containsKey(key)) {
                map.get(key).add(st);
            } else {
                map.put(key, new ArrayList<String>());
                map.get(key).add(st);
            }
            
        }
        
        return new ArrayList(map.values());
    }
}