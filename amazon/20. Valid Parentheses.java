/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not

*/

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() ==0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch :chars) {
            if(ch == ')'|| ch ==']' || ch == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                char prev = stack.pop();
                if(!match(prev,ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public boolean match(char  left, char right) {
        return (left == '(' && right ==')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }
}