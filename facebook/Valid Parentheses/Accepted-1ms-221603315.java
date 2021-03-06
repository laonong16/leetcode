// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/
// 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
                if (!isMatch(stack.pop(), ch)) {
                    return false;
                }
            } else {
                 stack.push(ch);
            }
        }
       return stack.isEmpty(); 
    }
    private boolean isMatch(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right ==']') || (left == '{' && right =='}');
    }
}

