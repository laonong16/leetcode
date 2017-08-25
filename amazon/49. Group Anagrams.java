/*
49. Group Anagrams
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
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        if(strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        for(String st : strs) {
            String key = getKey(st);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(st);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public String getKey(String st) {
        char[] chs = st.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}