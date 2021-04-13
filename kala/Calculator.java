import java.util.*;

class  Calculator {
    public static void main(String[] args) {
        System.out.println(basicCalculator1("-567+234"));
        System.out.println(basicCalculator2("3 + (  - 9 )  + 5"));
    }
    /*
    Pt.1 Calculator without parenthesis, only +, -, non-negative ints
     */
    public static int basicCalculator1(String expression){
        int num = 0, sum = 0, sign = 1; // 1 for +, -1 for -
        char[] chars = expression.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char cur = chars[i];
            if(Character.isDigit(cur)) num = num * 10 + Character.getNumericValue(cur);
            else if(cur == '+' || cur == '-'){
                sum += sign * num;
                num = 0;
                sign = (cur == '+') ? 1 : -1;
            }
        }
        if(num != 0) sum += sign * num;
        return sum;
    }
/*
Pt.2 Calculator with parenthesis (LeetCode 224)
O(n) time, O(n) worst case space
 */
public static int basicCalculator2(String expression){
    char[] chars = expression.toCharArray();
    int num = 0, sum = 0, sign = 1;
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < chars.length; i++){
        char cur = chars[i];
        if(Character.isDigit(cur)) num = num * 10 + Character.getNumericValue(cur);
        else if(cur == '+' || cur == '-'){
            sum += num * sign;
            num = 0;
            sign = (cur == '+') ? 1 : -1;
        }
        else if(cur == '('){
            stack.push(sum);
            stack.push(sign);
            sum = 0;
            num = 0;
            sign = 1;
        }
        else if(cur == ')'){
            sum += num * sign;
            sum = sum * stack.pop() + stack.pop();
            num = 0;
            // 3 + (  - 9 )  + 5
            // - 6
        }
    }
    if(num != 0) sum += sign * num;
    return sum;
}

}
