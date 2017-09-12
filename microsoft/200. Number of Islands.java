/*
200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '1') {
                    count++;
                    dfs(grid,row,col);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int row, int col) {
        if(grid[row][col] == '0' || grid[row][col] == '2') {
            return;
        }
        grid[row][col] = '2';
        if(row > 0) {
            dfs(grid,row-1,col);
        }
        if(row < grid.length - 1) {
            dfs(grid,row+1,col);
        }
        if(col > 0) {
            dfs(grid, row, col - 1);
        }
        if(col < grid[0].length - 1) {
            dfs(grid,row,col+1);
        }
    }
}