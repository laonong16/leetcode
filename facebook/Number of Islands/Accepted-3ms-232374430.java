// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Number of Islands
// https://leetcode.com/problems/number-of-islands/
// 

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int  j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfsFill(grid,i,j);
                }
            } 
        }
        return count;
    }
    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {row, col});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            row = cur[0];
            col = cur[1];
            grid[row][col] = '2';
            if (row > 0 && grid[row - 1][col] == '1') {
                que.offer(new int[] {row-1,col});
            }
             if (row <grid.length - 1 && grid[row + 1][col] == '1') {
                que.offer(new int[] {row+1,col});
            }
            if (col > 0 && grid[row][col - 1] == '1') {
                que.offer(new int[] {row,col - 1});
            }
           
            if (col < grid[0].length -1 && grid[row][col + 1] == '1') {
                que.offer(new int[] {row,col + 1});
            }
        }
    }
    private void  bfsFill(char[][] grid,int x, int y){
    grid[x][y]='0';
    int n = grid.length;
    int m = grid[0].length;
    LinkedList<int[]> queue = new LinkedList<>();  
      
    queue.offer(new int[] {x,y});  
    while(!queue.isEmpty())  
    {  
        int[] code = queue.poll();  
        int i = code[0];  
        int j = code[1];  
        if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
        {  
            queue.offer(new int[] {i-1,j});  
            grid[i-1][j]='0';  
        }  
        if(i<n-1 && grid[i+1][j]=='1')  //down
        {  
            queue.offer(new int[] {i+1,j});  
            grid[i+1][j]='0';  
        }  
        if(j>0 && grid[i][j-1]=='1')  //left
        {  
            queue.offer(new int[]{i,j-1});  
            grid[i][j-1]='0';  
        }  
        if(j<m-1 && grid[i][j+1]=='1')  //right
        {  
            queue.offer(new int[]{i,j+1});  
            grid[i][j+1]='0';  
        }
    } 
    }
}

