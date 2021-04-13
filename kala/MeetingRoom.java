import java.util.*;

class MeetingRoom {
    /*
    Input: int[][] meetings, int start, int end
        (e.g 13:00 => 1300, 9:30 => 930)

        Output: boolean, whether the new time could be scheduled as new meetings

        Sample:

        {[1300,1500],[930,1200],[830,845]},new meeting [820,830], return true, [1450,1500] return false

     */
    public static boolean meetingRooms1(int[][] meetings, int start, int end){
        for(int[] meeting : meetings){
            if((meeting[0] <= start && meeting[1] > start) || (meeting[0] < end && meeting[1] >= end)) return false;
        }
        return true;
    }
/*
Pt.2 Similar to Merge Intervals(LeetCode 56), but the output is different,
 now you are required to output idle time after time intervals merged, notice also output 0 - first start time.

 */
public static List<List<Integer>> meetingRooms2(int[][] intervals){
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> cur = new LinkedList<>();
    for(int[] pair : intervals){
        if(cur.isEmpty() || cur.getLast()[1] < pair[0]) cur.add(pair);
        else{
            cur.getLast()[1] = Math.max(cur.getLast()[1], pair[1]);
        }
    }
    List<Integer> Start_interval = new ArrayList<>();
    Start_interval.add(0);
    Start_interval.add(cur.get(0)[0]);
    ans.add(Start_interval);
    for(int i = 0; i < cur.size() - 1; i++){
        List<Integer> cur_interval = new ArrayList<>();
        cur_interval.add(cur.get(i)[1]);
        cur_interval.add(cur.get(i + 1)[0]);
        ans.add(cur_interval);
    }
    return ans;
}
    static List<int[]> available(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] prev = intervals[i-1];
            if(prev[1] < cur[0]) {
                res.add(new int[]{prev[1], cur[0]});
            }
        }
        int[] first = intervals[0];
        if(first[0] > 0) {
            res.add(0, new int[]{0, first[0]});
        }
        return res;
    }
    public static void main(String args[])
    {
        int[][] schedules = new int[][] {{1300,1500}, {930,1200}, {830,845}};
        int[] target1 = new int[] {820,830};
        int[] target2 = new int[] {1450,1500};
        System.out.println(meetingRooms1(schedules, 820,830));
        System.out.println(meetingRooms1(schedules, 1450,1500));
        List<int[]> result = available(schedules);
        for(int[] i: result){
            System.out.println(i[0] + " --> " + i[1]);
        }
        List<List<Integer>> res2 = meetingRooms2(schedules);
        System.out.println(res2);
    }
}