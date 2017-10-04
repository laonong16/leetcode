119. Pascal's Triangle II
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

public List<Integer> getRow(int rowIndex) {
        // List<Integer>  list = new ArrayList<>();
        // if(rowIndex < 0) {
        //     return list;
        // }
        // if(rowIndex == 0) {
        //     list.add(1);
        //     return list;
        // }
        // List<Integer> prev = getRow(rowIndex -1);
        // list.add(1);
        // for(int i = 0; i < rowIndex - 1; i++) {
        //     list.add(prev.get(i) + prev.get(i+1));
        // }
        // list.add(1);
        // return list;
        
        /*
        [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]

 T[i][j] represents ith row jth col 
 T[i][j] = T[i-1][j] + T[i-1][j-1] if i>0 && j>0
         Or
            =  1  if i=0
         Or
            =  T[i-1][j]  if j=0
]
        */
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
                res.add(0,1);
                for(int j=i-1;j>0;j--) {
                    res.set(j, res.get(j-1)+res.get(j));
                }
        }
        return res;
    }