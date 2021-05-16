import java.util.*;

class BadgeAccess {
/*
Pt.1
We are working on a security system for a badged-access room in our company's building.
Given an ordered list of employees who used their badge to enter or exit the room,
 write a function that returns two collection


All employees who didn't use their badge while exiting the room – they recorded an enter without a matching exix
All employees who didn't use their badge while entering the room  – they recorded an exit without a matching enter

badge_records = [
  ["Martha",   "exit"],
  ["Paul",     "enter"],.
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],.
  ["Paul",     "enter"],.
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
]
find_mismatched_entries(badge_records)
Expected output: ["Paul", "Curtis"], ["Martha"]

 */
    public static List<Set<String>> find_mismatched_entries(String[][] badge_records) {
        Map<String, Integer> badgeMap = new HashMap<>();
        for(String[] record: badge_records) {
            if(!badgeMap.containsKey(record[0])) {
                badgeMap.put(record[0], 0);
            }
            if(record[1].equals("exit")) {
                badgeMap.put(record[0], badgeMap.get(record[0] )- 1);
            } else {
                badgeMap.put(record[0], badgeMap.get(record[0] )+1);
            }
        }
        Set<String> exit_no_badge = new HashSet<>();
        Set<String> enter_no_badege = new HashSet<>();
        for(String emp :  badgeMap.keySet()) {
            if (badgeMap.get(emp) > 0) {
                enter_no_badege.add(emp);
            } else if(badgeMap.get(emp) < 0) {
                exit_no_badge.add(emp);
            }
        }
        List<Set<String>> result = new ArrayList<>();
        result.add(enter_no_badege);
        result.add(exit_no_badge);
        return result;
    }

    /*
    PT2 : 给 list of [name, time], time is string format: '1300' //下午一点
return: list of names and the times where their swipe badges within one hour.
 if there are multiple intervals that satisfy
the condition, return any one of them.

name1: time1, time2, time3...
name2: time1, time2, time3, time4, time5...
example:
input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
output: {
'Martha': ['1600', '1620', '1530']
}
     */
    public static Map<String, List<String>> multEntryInHour(String[][] records) {
        Map<String, List<Integer>> empEnterMap = new HashMap<>();
        for(String[] record: records) {
            if(!empEnterMap.containsKey(record[0])) {
                empEnterMap.put(record[0], new ArrayList<>());
            }
            empEnterMap.get(record[0]).add(Integer.parseInt(record[1]));

        }
        Map<String, List<String>> result = new HashMap<>();
        for(String emp: empEnterMap.keySet()) {
            if(empEnterMap.get(emp).size() >= 3) {
                List<Integer> list = empEnterMap.get(emp);
                Collections.sort(list);
                for(int start = 0; start < list.size(); start++) {
                    int end = start;
                    List<String> temp = new ArrayList<>();
                    while(end < list.size() && list.get(end) - list.get(start) <= 100) {
                        temp.add(""+list.get(end));
                        end++;
                        if(temp.size() >= 3) {
                            result.put(emp, temp);
                            break;
                        }
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String[][] records = new String[][]{
                {"Martha","exit"},
                {"Paul","enter"},
                {"Martha","enter"},
                {"Martha","exit"},
                {"Jennifer","enter"},
                {"Paul","enter"},
                {"Curtis","enter"},
                {"Paul","exit"},
                {"Martha","enter"},
                {"Martha","exit"},
                {"Jennifer", "exit"},
        };
        System.out.println(find_mismatched_entries(records));

        String[][] records2 = new String[][]{

                {"Paul","1355"},
                {"Jennifer","1910"},
                {"John","830"},
                {"Paul","1315"},
                {"John","835"},
                {"Paul","1405"},
                {"Paul","1630"},

                {"John","855"},

                {"John","915"},

                {"John","930"},

                {"Jennifer","1335"},

                {"Jennifer","730"},

                {"John","1630"},

        };
        System.out.println(multEntryInHour(records2));
    }
}