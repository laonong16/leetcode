// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Random Pick with Weight
// https://leetcode.com/problems/random-pick-with-weight/
// 

class Solution {
  int[] arr;
    int max = 0;
    Random random = new Random();
    public Solution(int[] w) {
        int[] arr = new int[w.length];
        arr[0] = w[0];
        max += w[0];
        for(int i=1; i<w.length; i++){
            arr[i] = arr[i-1] + w[i];
            max+=w[i];
        }
        this.arr = arr;
    }
    
    public int pickIndex() {
        int rnd = random.nextInt(max) + 1;  // generate random number in [1,max]
        //this returns the index of the random  number,
 //if the number does not exist in the array it returns  -(the position it should have been) - 1
        int ret = Arrays.binarySearch(arr, rnd); 
        if(ret < 0) ret = -ret - 1; //if not in the array 
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

