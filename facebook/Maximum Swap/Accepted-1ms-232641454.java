// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Maximum Swap
// https://leetcode.com/problems/maximum-swap/
// 

class Solution {
    public int maximumSwap(int num) {
           
      char nm[] = String.valueOf(num).toCharArray();        
        int max = Integer.parseInt(String.valueOf(nm));
        for(int i=0; i<nm.length; ++i){
            for(int j=i+1;j<nm.length; ++j){
                char temp = nm[j];
                nm[j] = nm[i];
                nm[i] = temp;
                 int check = Integer.parseInt(String.valueOf(nm));
                 max = Math.max(check, max);
                nm[i] = nm[j];
                nm[j] = temp;
                 
            }
        }
        return max;
    }
}
