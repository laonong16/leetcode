/*
640. Solve the Equation
Solve a given equation and return the value of x in the form of string "x=#value".

The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"
*/

class Solution {
    public String solveEquation(String equation) {
       if(equation == null || equation.length() == 0) {
	    return equation;
        }

        String[] parts = equation.split("=");
        String left = parts[0];
        String right = parts[1];

        int[] lco = process(left);
        int[] rco = process(right);

        int x = lco[0] - rco[0];
        int co = rco[1] - lco[1];

        if(x == 0) {
            if(co == 0) {
                return "Infinite solutions";
                } else {
            return "No solution";
            }
        } else if(co == 0) {
            return "x=0";
        } else {
            return "x=" + "" + String.valueOf((int) (co/x));
        }
    }
    
    public int[] process(String left) {
        char[] array = left.toCharArray();
        int length = array.length;
        int prev = 1;
        int x = 0;
        int co = 0;
        int cur = 0;

        for(int i = 0; i < length; ++i) {
                if(array[i] != 'x') {
            if(array[i] == '-') {
                prev = -1;
            } else if(array[i] == '+') {
                prev = 1;
            } else {
                cur = 0;
                    while(i < length && array[i] != '+' && array[i] != '-' && array[i] != 'x') {
                    cur = cur * 10 + ((int)(array[i] - '0'));
                i++;
                }
                if(i < length && array[i] == 'x') {
                    x = x + prev * ((int) (cur));
                i++;
                } else {
                co = co + prev * ((int) (cur));
                }
                --i;
                }
            } else {
                x += prev;
            }
        }
        return new int[]{x, co};
    }
}