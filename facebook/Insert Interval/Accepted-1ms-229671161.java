// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Insert Interval
// https://leetcode.com/problems/insert-interval/
// 

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList();
        
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        
        int i = 0;
        // add ends time < start;
        while(i < n && intervals[i][1] < start){
            res.add(intervals[i]);
            i++;
        }
        
        // merge starts time <= end
        while(i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start,end});
        
        while(i < n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]); 
    }
}
