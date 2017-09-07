/*
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

*/

/*
cut the string to differnt part,
if the left part is  Palindrome 
then  put it to the lists and continue cut the  right part
until cut index reach the end of string.
for example 
aab
cut 1  :  a, aa, aab  a, and aa is Palindrome do cut 2
cut 2 : for the a  rest will be "ab"
        it will be [a][a] amd [a][ab]
        so only [a][a] valid  move to cut 3  and get [a][a][b] and reach the last index so add {"a","a","b"} to the result
        for the [aa] , it will only hava [aa][b] and it is qualifid  and add it  to result
 
the tree structure for the process  of aab
                 []  
           v       v       n
           a       aa     aab  --------cut 1
       v     n      v
      a,a, a,ab    aa,b(reach last  add to result) 
      
     a,a,b(add to reault) 

*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,0,result, new ArrayList<String>());
        return result;
    }
    public void helper(String s, int start, List<List<String>> result, List<String> list) {
        if(start == s.length()) {
            result.add(new ArrayList<>(list));
            return ;
        }
        for(int i = start; i < s.length(); i++) {
            String sub = s.substring(start,i+1);
            if(!isPalindrome(sub)) {
                continue;
            }
            list.add(sub);
            helper(s, i+1, result, list);
            list.remove(list.size()-1);
        }
    }
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}