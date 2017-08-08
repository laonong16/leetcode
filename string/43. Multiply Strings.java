/*
43. Multiply Strings

Difficulty:Medium

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        
        for(int  i = len1 -1; i>=0; i--) {
            int n1 = num1.charAt(i) -'0';
            int k = len2+i;
            for(int j = len2 - 1; j>=0; j--) {
                int n2 = num2.charAt(j) -'0';
                int prod = n1 * n2 + result[k];
                result[k] = prod % 10;
                result[k-1] += prod / 10;
                k--;
            }
        }
       int index =0;
       while(index < len1+len2 && result[index] == 0) {
            index++;     
       }
       StringBuilder sb = new StringBuilder();
        while(index < len1+len2) { 
            sb.append(result[index++]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}