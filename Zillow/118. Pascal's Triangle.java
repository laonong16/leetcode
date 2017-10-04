118. Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        for(int i = 0 ; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            if(i == 0) {
                curList.add(1);
            } else {
                curList.add(1);
                List<Integer> prevList = result.get(i-1);
                for(int j = 0; j < i-1; j++) {
                    curList.add(prevList.get(j) + prevList.get(j+1));
                }
                curList.add(1);
            }
            result.add(curList);
        }
        return result;
    }
}