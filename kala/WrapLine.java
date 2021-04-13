/*
Wrap Lines:

Pt.1 Connecting words with '-' as blank spaces, no exceeds maxLength

Input: String[] words, int maxLength.
Output: List lines.
    e.g. ["1p3acres", "is", "a", "good", "place", "to", "communicate"], 12 => {"1p3acres-is", "a-good-place", "for", "communicate"}

O(n) time, O(n) space
 */
import  java.util.*;
class WrapLine {

    public static List<String> wrapLines1(String[] words, int maxLength){
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while(p < words.length){
            if(sb.length() == 0)
                // assume all words length no exceed to maxLength
                sb.append(words[p++]);

            else if(sb.length() + 1 + words[p].length() <= maxLength){
                sb.append('-');
                sb.append(words[p++]);
            }
            else{
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length() != 0) ans.add(sb.toString());
        return ans;
    }

    /*
     Pt.2 Require every line to be "balanced".

Input: String[] lines, ["the way it moves like me", "another sentence example",...], int maxLength.
Output: List lines.
e.g. ["123 45 67 8901234 5678", "12345 8 9 0 1 23"], 10 => {"123--45-67", "8901234", "5678-12345", "8-9-0-1-23"}
["123 45 67 8901234 5678", "12345 8 9 0 1 23"], 15 => {"123----45----67", "8901234----5678", "12345---8--9--0", "23"}

     */


    public static List<String> wrapLines2(String[] lines, int maxLength){
        List<String> unbalanced = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for(String line : lines){
            String[] word_collection = line.split(" ", -1);
            Collections.addAll(words, word_collection);
        }
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while(p < words.size()){
            if(sb.length() == 0)
                // assume all words length no exceed to maxLength
                sb.append(words.get(p++));

            else if(sb.length() + 1 + words.get(p).length() <= maxLength){
                sb.append('-');
                sb.append(words.get(p++));
            }
            else{
                unbalanced.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length() != 0) unbalanced.add(sb.toString());
        //now we have un-balanced result, then balance it
        List<String> balanced = new ArrayList<>();
        for(String line : unbalanced){
            StringBuilder cur_line = new StringBuilder(line);
            int num_needed = maxLength - cur_line.length();
            if(!cur_line.toString().contains("-")){
                balanced.add(cur_line.toString());
                continue;
            };
            while(num_needed > 0){
                int i = 0;
                while(i < cur_line.length() - 1){
                    if(cur_line.charAt(i) == '-' && cur_line.charAt(i + 1) != '-'){
                        cur_line.insert(i + 1, '-');
                        num_needed--;
                        i++;
                        if(num_needed == 0) break;
                    }
                    i++;
                }
            }
            balanced.add(cur_line.toString());
        }
        return balanced;
    }
/*
Pt.3 Assuming only one "-" between words, but define "score": sum of difference square between each line length
and the length of longest line (like variance), how to wrap can minimize the score. How long for each line is not limited. (dp)

 */
    public static void main (String[] args) {
        String[] words = new String[] {"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        System.out.println(wrapLines1(words, 20));
        String[] words2 = new String[] {"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        System.out.println(wrapLines2(words2, 10));
    }
}
