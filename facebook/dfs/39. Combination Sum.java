class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(result, candidates,0, new ArrayList<Integer>(),target);
        return result;
    }
    private void helper(List<List<Integer>> result, int[] candidates,int pos,  List<Integer> list,int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
        }
        for (int i = pos; i <  candidates.length; i++) {
            if (target >= candidates[i]) {
                list.add(candidates[i]);
                helper(result, candidates, i, list, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}