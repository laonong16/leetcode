// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Merge Intervals
// https://leetcode.com/problems/merge-intervals/
// 

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, (it1,it2) -> it1.start - it2.start);
        Interval prev = null;
        for (Interval it : intervals) {
            if (prev == null) {
                prev = it;
            } else if (prev.end  < it.start) {
                result.add(prev);
                prev = it;
            } else {
                prev.end = it.end;
            }
        }
        result.add(prev);
        return result;
    }
}

