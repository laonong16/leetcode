// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Reorganize String
// https://leetcode.com/problems/reorganize-string/
// 

class Solution {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) counts[c-'a'] += 26;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 30*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code: counts) {
            int ct = code / 26;
            char ch = (char) ('a' + (code % 26));
            if (ct > (N+1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }
    
}

