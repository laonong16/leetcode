// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Longest Arithmetic Sequence
// https://leetcode.com/problems/longest-arithmetic-sequence/
// 

class Solution {
    public int longestArithSeqLength(int[] A) {
       Map<Integer, Map<Integer, Integer>> idxToDiffToCount = new HashMap<>();
        int n =A.length;
        int res = 2;
        for(int i = 0; i < n; ++i) {
                idxToDiffToCount.put(i, new HashMap<>());
            for(int j = 0; j < i; ++j) {
                int diff = A[i] - A[j];
                idxToDiffToCount.get(i).put(diff, 1 + idxToDiffToCount.get(j).getOrDefault(diff, 1));
                res = Math.max(res, idxToDiffToCount.get(i).get(diff));
                
            }
        }
        return res;
    }
}

