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

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) {
            return result;
        }
        helper(nums,0,result,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for(int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i+1, result,list);
            list.remove(list.size() - 1);
        }
    }
}