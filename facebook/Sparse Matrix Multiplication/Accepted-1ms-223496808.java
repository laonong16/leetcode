// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Sparse Matrix Multiplication
// https://leetcode.com/problems/sparse-matrix-multiplication/
// 

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        Map<Integer,Map<Integer,Integer>> mapA = preProcess(A);
        Map<Integer,Map<Integer,Integer>> mapB = preProcess(B);
        int[][]result = new int[A.length][B[0].length];
        for(int i : mapA.keySet()) {
            Map<Integer,Integer> rowA = mapA.get(i);
            for(int k : rowA.keySet()) {
                Map<Integer,Integer> colB = mapB.get(k);
                if(colB != null) {
                    for(int j : colB.keySet()) {
                        result[i][j] += rowA.get(k) * colB.get(j);
                    }
                }
            }
        }
        return result;
    }
    Map<Integer,Map<Integer, Integer>>  preProcess(int[][] A) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
             Map<Integer,Integer> valMap = new HashMap<>();         
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    valMap.put(j, A[i][j]);
                    map.put(i, valMap);
                }
            }
        }
        return map;
    }
}

