/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 */

/*
thought :
The idea is straightforward, with the input string s,
 we generate all possible states by removing one ( or ), check if they are valid,
 if found valid ones on the current level, put them to the final result list and we are done,
 otherwise, add them to a queue and carry on to the next level.

The good thing of using BFS is that we can guarantee the number of parentheses that need to be removed is minimal, also no recursion call is needed in BFS.
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //BFS
        boolean find = false;
        Queue<String> que = new LinkedList<>();
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        que.offer(s);
        while (!que.isEmpty()) {
            String cur = que.poll();
            if (isValid(cur)) {
                result.add(cur);
                find = true;
                if(que.isEmpty()) return result;
            }
            if(!find){
                for (int i = 0; i < cur.length(); i++) {
                    char ch = cur.charAt(i);
                    if (ch == '(' || ch == ')') {
                        if( i < cur.length()  - 1 && cur.charAt(i) == cur.charAt(i+1)) {
                            continue;
                        }
                        String curSt = cur.substring(0, i) + cur.substring(i+1);
                        if (visited.add(curSt)) {
                            que.offer(curSt);
                        }

                    }
                }
            }
        }
        return result;
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