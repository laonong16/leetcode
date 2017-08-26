/*
139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 参数校验
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        // 标记是否匹配，match[i]表表[0, i-1]都匹配
        int length = s.length();
        boolean[] match = new boolean[length + 1];
        match[0] = true;

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    // f(0,n) = f(0,i) + f(i,j) + f(j,n)
                    match[i] = true;
                    break;
                }
            }
        }
        return match[length]; 
    }
}