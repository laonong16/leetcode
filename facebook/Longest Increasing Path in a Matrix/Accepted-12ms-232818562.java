// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Longest Increasing Path in a Matrix
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// 

class Solution {
    Integer[][] dp = null;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        dp = new Integer[m][n];
        int max = 0;
        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++)
                max = Math.max(max, dfs(matrix, i, j, -Integer.MAX_VALUE));
        return max;
    }
    //dp[i][j] = longest from this node
    private int dfs(int[][] matrix, int i, int j, int prev){
        if(i < 0 || j < 0 || i == matrix.length || j == matrix[0].length || prev >= matrix[i][j]) return 0;
        if(dp[i][j] != null)
        	return dp[i][j];
        
        dp[i][j] = Math.max(1, 1+dfs(matrix, i+1, j, matrix[i][j]));
        dp[i][j] = Math.max(dp[i][j], 1+dfs(matrix, i-1, j, matrix[i][j]));
        dp[i][j] = Math.max(dp[i][j], 1+dfs(matrix, i, j-1, matrix[i][j]));
        dp[i][j] = Math.max(dp[i][j], 1+dfs(matrix, i, j+1,matrix[i][j]));
        return dp[i][j];
    }
    
}

