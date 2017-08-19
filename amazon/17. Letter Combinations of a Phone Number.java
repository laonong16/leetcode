/*
17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        helper(digits, 0, "", result);
        return result;
    }
    
    public void helper(String digits, int index, String st, List<String> result) {
        if(st.length() == digits.length()) {
            result.add(st);
            return;
        }
        String curSt = getChars(digits.charAt(index));
        for(char ch : curSt.toCharArray()) {
            helper(digits, index+1, st + ch, result);
        }
    }
    public String getChars(char ch) {
        String st = "";
        switch (ch) {
            case '2' : st ="abc";
                        break;
            case '3' : st ="def";
                        break; 
            case '4' : st ="ghi";
                        break;
            case '5' : st ="jkl";
                        break; 
            case '6' : st ="mno";
                        break;
            case '7' : st ="pqrs";
                        break; 
            case '8' : st ="tuv";
                        break;
            case '9' : st ="wxyz";
                        break; 
                
        }
        return st;
    }
}