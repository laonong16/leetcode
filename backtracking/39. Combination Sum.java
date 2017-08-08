/*
39. Combination Sum

Difficulty:Medium

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

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates,result, new ArrayList<Integer>(), 0, target);
        return result;
    }
    public void helper(int[] candidates, List<List<Integer>> result, List<Integer> list, int index, int target) {
        if(0 == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            helper(candidates, result, list, i, target - candidates[i]);
            list.remove(list.size() - 1);
           }
    }
}