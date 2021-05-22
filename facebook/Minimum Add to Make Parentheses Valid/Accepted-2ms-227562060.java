// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Minimum Add to Make Parentheses Valid
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
// 

class Solution {
    public int minAddToMakeValid(String S) {
        Stack stack = new Stack();
        char[] chs = S.toCharArray();
        int count = 0;
        for(char ch : chs){
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(ch == ')' && !stack.empty()){
                    stack.pop();    
                }
                else{
                    count++;
                }   
            }
        }
        return count + stack.size();
    }
}
