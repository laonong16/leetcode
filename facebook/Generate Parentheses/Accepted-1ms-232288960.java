// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/
// 

class Solution {
    //backracking  dfs  use left parenthesis  count and right parentheis count
    // if both n  add it to result;
     
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if ( n <= 0) {
            return result;
        }
         
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    private void helper(List<String> result, StringBuilder sb, int leftCount, int rightCount, int total) {
        if(leftCount >total || rightCount >total ||  leftCount < rightCount) {
            return ;
        }
        if (leftCount == total && rightCount == total) {
            result.add(sb.toString());
            return;
        }
        sb.append("(");
        helper(result,sb, leftCount +1  , rightCount,total);
        sb.setLength(sb.length() - 1);
        sb.append(")");
        helper(result, sb, leftCount, rightCount + 1,total);
        sb.setLength(sb.length() - 1);
    }
}
