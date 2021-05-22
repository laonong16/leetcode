import java.util.*;


public class Tiles {
    /*
    1. A tile can be any number from 0 to 9. Give a hand of tiles, a complete hand consists of a pair, and any number (including zero) of triple.
# hand1 = "11122"   => True. 111 22
# hand2 = "12121"   => True. 111 22
# hand3 = "11111555"  => True. 111 11 555
# hand6 = "123456"  => False. Needs a pair
     */
    public static boolean hasPairAndTriple(String[] pair) {
        String hands = pair[1];
        int[] tiles = new int[10];
        for(char ch : hands.toCharArray()) {
            tiles[ch-'0']++;
        }
        int countPair = 0;
        int countTriple = 0;
        for(int num : tiles) {
            if(num == 0) continue;;
            if(num % 2 == 0) {
                countPair+= num/2;
            }
            if (num % 3 == 0) {
                countTriple+= num/3;
            }
            if(num % 5 == 0) {
                countPair += num/5;
                countTriple += num /5;
            }
        }
        return countPair == 1;
    }
    /*
     Give a board with tiles. When a gamer chooses one tile,
      he can take all adjacent tiles with same number on it.
      Write a function to return how many tiles could take.
        grid =
        [[4,4,4,4],
        [3,6,6,4],
        [5,5,5,5],
        [1,0,0,0]]
        disappear(grid, 0, 0) => 5. 可以拿走5张4
        disappear(grid, 2, 1) => 4. 可以拿走4张5
        disappear(grid, 3, 1) => 3. 可以拿走3张0
     */
    public static int disappear(int[][] grid, int row,int col) {
        int target = grid[row][col];
        grid[row][col] = 10;
        Queue<int[]> queue = new LinkedList<>();;
        queue.offer(new int[]{row,col});
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int[] pos = queue.poll();
            int curR = pos[0];
            int curC = pos[1];
            if (curR > 0 && grid[curR - 1][curC] == target) {
                grid[curR - 1][curC] = 10;
                queue.offer(new int[]{curR - 1, curC});
            }
            if (curR < grid.length - 1 && grid[curR + 1][curC] == target) {
                grid[curR + 1][curC] = 10;
                queue.offer(new int[]{curR + 1, curC});
            }
            if (curC > 0 && grid[curR][curC- 1] == target) {
                grid[curR][curC - 1] = 10;
                queue.offer(new int[]{curR, curC - 1});
            }
            if (curC < grid[0].length - 1 && grid[curR][curC + 1] == target) {
                grid[curR][curC + 1] = 10;
                queue.offer(new int[]{curR, curC + 1});
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] pair = new String[]{"hande1","123456"};
        System.out.println(hasPairAndTriple(pair));
        int[][]  grid =
                {{4, 4, 4, 4},
                        {3, 6, 6, 4},
                        {5, 5, 5, 5},
                        {1, 0, 0, 0}};
        System.out.println(disappear(grid,0,0));
        System.out.println(disappear(grid,2,1));
        System.out.println(disappear(grid,3,3));
    }
}