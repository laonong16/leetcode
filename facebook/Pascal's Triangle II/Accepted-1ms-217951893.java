// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Pascal's Triangle II
// https://leetcode.com/problems/pascals-triangle-ii/
// 

class Solution {
    public List<Integer> getRow(int rowIndex) {
          List<Integer> row = new ArrayList <>();
        for(int i = 0;i<=rowIndex;i++){
            row.add(0,1);
            for(int j=1;j<row.size()-1;j++)
            row.set(j,row.get(j)+row.get(j+1));
        }
        return row;
    }
}
