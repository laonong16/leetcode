/*
119. Pascal's Triangle II
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex == 0) {
            result.add(1);
        } else {
            List<Integer> list = getRow(rowIndex - 1);
            result.add(0,1);
            for(int i = 0; i < list.size() - 1; i++) {
                result.add(list.get(i) + list.get(i+1));
            }
            result.add(result.size(), 1);
        }
        return result;
    }
}
