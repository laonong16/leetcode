/*
Suppose we have an unsorted log file of accesses to web resources.
Each log entry consists of an access time, the ID of the user making the access,
 and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed
 to be in the same day.

For example:
logs = [
["58523", "user_1", "resource_1"],
["62314", "user_2", "resource_2"],
["54001", "user_1", "resource_3"],
["200", "user_6", "resource_5"],
["215", "user_6", "resource_4"],
["54060", "user_2", "resource_3"],
["53760", "user_3", "resource_3"],
["58522", "user_4", "resource_1"],
["53651", "user_5", "resource_3"],
["2", "user_6", "resource_1"],
["100", "user_6", "resource_6"],
["400", "user_7", "resource_2"],
["100", "user_8", "resource_2"],
["54359", "user_1", "resource_3"],
]

Question:
Write a function that takes the logs and returns each users min and max access timestamp
Example Output:
user_3:[53760,53760]
user_2:[54060,62314]
user_1:[54001,58523]
user_7:[400,400]
user_6:[2,215]
user_5:[53651,53651]
user_4:[58522,58522]
user_8:[100,100]

Follow-up:
Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.
Example:
('resource_3', 3)
 */
import java.util.*;
class UserLog {

    public static Map<String, String> getMinMaxLogs(String[][] logs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(String[] log: logs) {
            String userId = log[1];
            int accessTime = Integer.parseInt(log[0]);
            if (!map.containsKey(userId)) {
                map.put(userId, new ArrayList<>());
                map.get(userId).add(accessTime);
                map.get(userId).add(accessTime);
            }
            List<Integer> list =  map.get(userId);
            list.set(0, Math.min(accessTime, list.get(0)));
            list.set(1, Math.max(accessTime, list.get(1)));
            map.put(userId, list);

        }
        Map<String, String> res = new HashMap<>();
        for(String key : map.keySet()) {
            res.put(key, key +":" +map.get(key) +"");
        }
        return res;
    }

    public static String getHighest(String[][] logs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(String[] log: logs) {
            String resourceId = log[2];
            int accessTime = Integer.parseInt(log[0]);
            if (!map.containsKey(resourceId)) {
                map.put(resourceId, new ArrayList<>());
            }
            map.get(resourceId).add(accessTime);
        }
        Map<String, String> result = new HashMap<>();
        int theMost = 0;
        String resSt = "";
        for(String key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            int max = 0;
            for(int start = 0; start < list.size(); start++) {
                int end = start + 1;
                int freq = 1;
                while(end < list.size() && list.get(end) -list.get(start) <= 300){
                    freq++;
                    end++;
                }
                max = Math.max(max,freq);
            }
            result.put(key, key + ":" + max);
            if(theMost < max) {
               resSt = result.get(key);
               theMost = max;
            }
        }
        return resSt;
    }
    public static void main(String[] args) {
        String[][] logs = new String[][] {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_4", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_2"},
                {"54359", "user_1", "resource_3"}
        };
        Map<String, String> res = getMinMaxLogs(logs);
        System.out.println(res.values());
        System.out.println(getHighest(logs));
    }
}
