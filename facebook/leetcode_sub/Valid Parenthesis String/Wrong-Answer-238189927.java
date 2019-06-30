// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Valid Parenthesis String
// https://leetcode.com/problems/valid-parenthesis-string/
// 

class Solution {
    /*
    这道题不只有小括号，还存在星号，星号可以当左括号，右括号，或空来使用，问我们能不能得到一个合法的括号字符串。那么我们想，如果不存在星号，那么这题是不是异常的简单，我们甚至连stack都可以不用，直接用一个变量，遇到左括号，自增1，遇到右括号，如果此时计数器已经为0了，直接返回false，否则自减1，一旦计数器出现了负数，立即返回false，最后还要看变量是否为0即可。但是由于星号的存在，这道题就变的复杂了，由于星号可以当括号用，所以当遇到右括号时，就算此时变量为0，也可以用星号来当左括号使用。那么星号什么时候都能当括号来用吗，我们来看两个例子 *) 和 *( ，在第一种情况下，星号可以当左括号来用，而在第二种情况下，无论星号当左括号，右括号，还是空，*( 都是不对的。当然这种情况只限于星号和左括号之间的位置关系，而只要星号在右括号前面，就一定可以消掉右括号。那么我们使用两个stack，分别存放左括号和星号的位置，遍历字符串，当遇到星号时，压入星号栈star，当遇到左括号时，压入左括号栈left，当遇到右括号时，此时如果left和star均为空时，直接返回false；如果left不为空，则pop一个左括号来抵消当前的右括号；否则从star中取出一个星号当作左括号来抵消右括号。当循环结束后，我们希望left中没有多余的左括号，就算有，我们可以尝试着用星号来抵消，当star和left均不为空时，进行循环，如果left的栈顶左括号的位置在star的栈顶星号的右边，那么就组成了 *( 模式，直接返回false；否则就说明星号可以抵消左括号，各自pop一个元素。最终退出循环后我们看left中是否还有多余的左括号，没有就返回true，否则false，
    */
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Integer> starIndex = new Stack<>();
        Stack<Integer> leftIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '*') {
                starIndex.push(i);
            } else if (ch == '(') {
                leftIndex.push(i);
            } else {
                if(starIndex.isEmpty() && leftIndex.isEmpty()) {
                    return false;
                }
                if(!leftIndex.isEmpty()) {
                    leftIndex.pop();
                }
            }
        }
        while (!starIndex.isEmpty() && !leftIndex.isEmpty()) {
            if(starIndex.peek() < leftIndex.peek()) {
                return false;
            }
            starIndex.pop();
            leftIndex.pop();
        }
        return  leftIndex.isEmpty();
    }
}

