/*
46. Permutations

Difficulty:Medium

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(result,nums,new ArrayList<>());
        return result;
    }
    public void  helper(List<List<Integer>> result, int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(result,nums,list);
            list.remove(list.size() - 1);
        }
    }
}