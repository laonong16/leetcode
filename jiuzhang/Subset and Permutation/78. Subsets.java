/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums,0,result,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int start, List<List<Integer>> result, List<Integer> curList) {
        result.add(new ArrayList<>(curList));
        for(int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            helper(nums, i+1, result, curList);
            curList.remove(curList.size() - 1);
        }
    }
}