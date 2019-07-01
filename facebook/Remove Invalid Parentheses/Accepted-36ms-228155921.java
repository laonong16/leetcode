// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Remove Invalid Parentheses
// https://leetcode.com/problems/remove-invalid-parentheses/
// 

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //BFS 
         Queue<String> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (isValid(cur)) {
                list.add(cur);
                flag = true;
               
            }
            if (!flag) {
                int len = cur.length();
                for (int i = 0; i < len; i ++) {
                    if(cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                        //33ms
                        if (i + 1 < len && cur.charAt(i) == cur.charAt(i + 1)) {
                            continue;
                        }
                        String nxt = cur.substring(0, i) + cur.substring(i + 1, len);
                        if (set.add(nxt)) {
                            q.add(nxt);
                        }
                    }
                }
            }
        }
        return list;
    }
   boolean isValid(String s) {
        int len = s.length();
        int l = 0;
        for (int i = 0; i < len; i ++) {
            if (s.charAt(i) == '(') {
                l ++;
            }
            else if (s.charAt(i) == ')'){
                l --;
            }
            if (l < 0) {
                return false;
            }
        }
        return l == 0;
    }
}

