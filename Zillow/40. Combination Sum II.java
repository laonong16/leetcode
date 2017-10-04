40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique 
combinations in C where the candidate numbers sums to T.

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


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates,result,target, new ArrayList<Integer>(),0);
        return result;
    }
    public void helper(int[] candidates, List<List<Integer>> result, int target,List<Integer> list, int nextIndex) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = nextIndex; i< candidates.length; i++){
            if(i > nextIndex && candidates[i] == candidates[i-1]) continue;
            if(target >= candidates[i]) {
                list.add(candidates[i]);
                helper(candidates,result,target - candidates[i],list, i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}