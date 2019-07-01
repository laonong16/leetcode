// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Backspace String Compare
// https://leetcode.com/problems/backspace-string-compare/
// 

class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (isEmpty(S) && isEmpty(T)) {
            return true;
        }
       if (isEmpty(S) || isEmpty(T)){
            return false;
       }
        String s = helper(S);
        String t = helper(T);
        return s.equals(t);
    }
    public String helper(String st) {
        StringBuilder sb = new StringBuilder();
        int index = st.length() - 1;
        int count = 0;
        while(index >= 0) {
            char ch = st.charAt(index);
            index--;
            if (ch != '#') {
                sb.append(ch);
            } else {
                count++;
                while(index >= 0) {
                     char next = st.charAt(index);
                    if(next != '#') {
                        count--;
                        index--;
                        if(count == 0)
                            break;
                    } else {
                        index--;
                        count++;
                    }
                }
            }
        }
        return sb.toString();
    }
    public boolean isEmpty(String st) {
        return st == null || st.length() == 0;
}
}

