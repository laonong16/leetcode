/*
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/

// solution 1 two round  binary search 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        

        // two round  binary search
        // first round find the row number
        int startRow = 0;
        int endRow = matrix.length - 1;
        int midRow = 0;
        while(startRow + 1 < endRow) {
            midRow = startRow + (endRow - startRow) / 2;
            int val = matrix[midRow][0];
            if(val == target) {
                return true;
            }
            if(val < target) {
               startRow = midRow;
            } else {
                endRow = midRow;
            }
        }
        if (matrix[endRow][0] <= target) {
            midRow = endRow;
        } else if (matrix[startRow][0] <= target) {
            midRow = startRow;
        } else {
            return false;
        }

        //second round fine the  target exist in the row
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int midCol = 0; 
        while(startCol + 1 < endCol) {
            midCol = startCol + (endCol - startCol) / 2;
            int val = matrix[midRow][midCol];
            if(val == target) {
                return true;
            }
            if(val < target) {
                startCol = midCol;
            }else {
                endCol = midCol;
            }
        }
         if (matrix[midRow][endCol] == target) {
            return true;
        } else if (matrix[midRow][startCol] == target) { 
            return true;
        }
        return false;
    }
}

// solution 2  binary seach one time
 class Solution {
    // one time  binary search
    /*
    start = 0 end = m * n -1
    mid = end -start / 2
    row = mid / n
    col = mid % n
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
           return false;
        } 
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        while(start+1 < end) {
           int mid = start + (end - start) / 2;
           row = mid / n;
           col = mid % n;
           int val = matrix[row][col];
           if(val == target) {
               return true;
           }
           if(val < target) {
               start = mid;
           } else {
               end = mid;
           }
        }
        row = end / n;
        col = end % n;
        if(matrix[row][col] == target) {
            return true;
        }
        row = start / n;
        col = start % n;
        if(matrix[row][col] == target) {
            return true;
        }
        return false;
    }
}