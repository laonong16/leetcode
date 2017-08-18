/*
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        helper(s,0,result,"", new Integer(0));
        return result;
    }
    public void helper(String s, int startIndex, List<String> result, String ip,Integer totalDot) {
        if(startIndex == s.length() && totalDot  == 3) {
            result.add(ip);
            return;
        }
        for(int i = startIndex; i < startIndex+3 && i < s.length(); i++) {
            String sub = s.substring(startIndex,i+1);
            if(validate(sub)) {
                if(ip == "") {
                   helper(s, i+1,result, sub, totalDot);
                } else {
                    totalDot++;
                    helper(s, i+1,result, ip + "." + sub, totalDot);
                    totalDot--;
                }
                
            }
        }
    }
    
    private boolean validate(String ip) {
        if(ip.length() > 3) {
            return false;
        }
        if(ip.length() > 1 && ip.charAt(0) == '0') {
            return false;
        }
        if(Integer.parseInt(ip) > 255) {
            return false;
        }
        return true;
    }
}