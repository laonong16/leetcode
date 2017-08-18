/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

1, sort array,
2. skip the same value  by using boolean array
3. backtracking
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       if(nums == null || nums.length == 0) {
            return result; 
       }
        Arrays.sort(nums);
        helper(nums,new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }
    public void helper(int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] visited) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if((i != 0 && nums[i] == nums[i-1] && visited[i-1]) || visited[i])  {
                continue;
            } 
            list.add(nums[i]);
            visited[i] = true;
            helper(nums,list,result,visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}