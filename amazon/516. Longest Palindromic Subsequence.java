/*516. Longest Palindromic Subsequence
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/

class Solution {
    /*
    dp[i][j]表示s[i .. j]的最大回文子串长度
    dp[i][j] = dp[i + 1][j - 1] + 2           if s[i] == s[j]
    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])    otherwise
    return dp[0][n]
    */
    public int longestPalindromeSubseq(String s) {
       int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1]; 
    }
}