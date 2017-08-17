/*
368. Largest Divisible Subset
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
*/

//TLE but good practice for subsets 
public class Solution {
     List<Integer> result = new ArrayList<>();
       
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }
    public void helper(int[] nums, int start, List<Integer> list) { 
        if(list.size() > result.size()) {
            result = new ArrayList<>(list);
        }
        for(int i = start; i < nums.length; i++) {
            if(isValid(list, nums[i])) {
                list.add(nums[i]);
                helper(nums,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isValid(List<Integer> list, int num) {
        if(list.size() == 0) {
            return true;
        }
        for(int tmp : list) {
            if(tmp % num != 0 && num % tmp != 0) {
                return false;
            }
        }
        return true;
    }
}

// DP solution 
 public List<Integer> largestDivisibleSubset(int[] nums) {
       int n = nums.length;
            int[] count = new int[n];
            int[] pre = new int[n];
            Arrays.sort(nums);
            int max = 0, index = -1;
            for (int i = 0; i < n; i++) {
                count[i] = 1;
                pre[i] = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        if (1 + count[j] > count[i]) {
                            count[i] = count[j] + 1;
                            pre[i] = j;
                        }
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
            List<Integer> res = new ArrayList<>();
            while (index != -1) {
                res.add(nums[index]);
                index = pre[index];
            }
            return res;
        }