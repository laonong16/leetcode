/*
39. Combination Sum
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        helper(candidates,0, new ArrayList<>(),result,target);
        return result;
    }
    public void helper(int[] candidates, int startIndex, 
                       List<Integer> list, List<List<Integer>> result, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
        }
        for(int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                list.add(candidates[i]);
                helper(candidates, i, list, result, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}