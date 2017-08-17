/*
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        } 
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    public void helper(int[] nums, int start, List<Integer> curList, List<List<Integer>> result) {
        result.add(new ArrayList<>(curList));
        for(int i = start; i < nums.length; i++) {
            if(i != start && nums[i] == nums[i-1]) {
                continue;
            }
            curList.add(nums[i]);
            helper(nums,i+1, curList, result);
            curList.remove(curList.size() - 1);
        }
    }
}