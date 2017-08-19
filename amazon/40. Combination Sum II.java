/*
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, new ArrayList<>(), result, target);
        return result;
    }
    
    public void helper(int[] candidates, int startIndex, List<Integer> list, 
                      List<List<Integer>> result, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++) {
            if( i != startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] <= target) {
                list.add(candidates[i]);
                helper(candidates, i+1, list, result, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
        
    }
}