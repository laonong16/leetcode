// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Wildcard Matching
// https://leetcode.com/problems/wildcard-matching/
// 

class Solution {
    public boolean isMatch(String s, String p) {
        /*
        Use a 2D array dp, and calculate the decision one by one. Again, the most tricky thing is
to decide the result when * is hit. There are three possibilities:

dp[i - 1][j]: * matches nothing
dp[i][j - 1]: * matches current char plus one or more previous chars of input string. It means, the pattern string p[0..i] (the latest char p[i] is *) matches the input string s[0..j-1]. Since * can match any char, of course p[0..i] can matches s[0..j] as well.
dp[i - 1][j - 1]: * matches current char of input string
Only one of the three possibilities is needed. The relevant code:

dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
We can find case #2 includes case 3#: when p[0..i-1] matches s[0..j-1], and p[i] is '*', it's actually one of the possibilities of case #2. So the code can be simplified to:

dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        */
        
        
        int n = s.length(), m = p.length();
        // If both input string and pattern are empty, they are matched
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // For the first row (pattern is empty, and input string is not), the results are false by default
        // For the first column (input string is empty, and pattern is not):
        // If current pattern char is not '*', the result is false;
        // If current pattern char is '*', the result is previous row (dp[i - 1][0])
        for(int i = 1;i <= m;i++)dp[i][0] = p.charAt(i - 1) == '*' ? dp[i - 1][0] : false;
        for(int i = 1;i <= m;i++) {
            char pChr = p.charAt(i - 1);
            for(int j = 1;j <= n;j++) {
                char chr = s.charAt(j - 1);
                if(pChr == '?')dp[i][j] = dp[i - 1][j - 1];
                else if(pChr == '*')dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = pChr == chr && dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
