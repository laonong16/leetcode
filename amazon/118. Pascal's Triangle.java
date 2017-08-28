/*
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
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>();
       if(numRows <=0)
            return result;          
       List<Integer> list = new ArrayList<>();
       list.add(1);
       result.add(list);
       for( int i = 2; i <= numRows; i++) {
           List<Integer> temp = new ArrayList<>();
           temp.add(1);
           List<Integer> prevList = result.get(result.size() - 1);
           for(int j = 0; j < prevList.size() - 1; j++) {
               temp.add(prevList.get(j) + prevList.get(j+1));
           }
           temp.add(temp.size(),1); 
           result.add(temp);          
        }
       return result;
    }
}