// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Toeplitz Matrix
// https://leetcode.com/problems/toeplitz-matrix/
// 

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0 ||matrix[0].length ==0) {
            return true;
        }
        for (int i = 0; i <matrix.length-1; i++) {
            for (int j = 0; j < matrix[0].length-1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

