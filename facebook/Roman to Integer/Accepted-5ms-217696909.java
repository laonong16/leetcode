// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Roman to Integer
// https://leetcode.com/problems/roman-to-integer/
// 

class Solution {
    static Map<Character, Integer> romanMap = new HashMap<>();
   static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X',10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D',500);
        romanMap.put('M',1000); 
   }
    public int romanToInt(String s) {
        
        
        if(s == null ||s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return romanMap.get(s.charAt(0));
        }
        int index = 0;
        int sum = 0;
        
        while(index < s.length() - 1) {
            char cur = s.charAt(index + 1);
            char prev = s.charAt(index);
          
            if(romanMap.get(prev) < romanMap.get(cur)) {
                sum = sum + romanMap.get(cur) - romanMap.get(prev);
                index++;
            } else {
                sum = sum + romanMap.get(prev) ;
            }
            index++;
        }
        if (index == s.length() - 1)
        sum+= romanMap.get(s.charAt(index));
        return sum;
    }
}

