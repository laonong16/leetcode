import java.util.*;

class CourseSchedule {
 /*
 Pt.1 You are a developer for a university. Your current project is to develop a system for students
  to find courses they share with friends. The university has a system for querying courses students are enrolled in,
  returned as a list of (ID, course) pairs.
Write a function that takes in a list of (student ID number, course name) pairs and returns,
for every pair of students, a list of all courses they share.
Sample Input:

student_course_pairs_1 = [
  ["58", "Software Design"],
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
]
Sample Output (pseudocode, in any order):
find_pairs(student_course_pairs_1) =>
{
  [58, 17]: ["Software Design", "Linear Algebra"]
  [58, 94]: ["Economics"]
  [58, 25]: ["Economics"]
  [94, 25]: ["Economics"]-baidu 1point3acres
  [17, 94]: []
  [17, 25]: []
}
Additional test cases:

Sample Input:

student_course_pairs_2 = [
  ["42", "Software Design"],
  ["0", "Advanced Mechanics"],
  ["9", "Art History"],
]

Sample output:

find_pairs(student_course_pairs_2) =>
{
  [0, 42]: []
  [0, 9]: []
  [9, 42]: []
}

 Solution:
 iterate m * n courses and write into hashmap,
 then going over between n^2 pairs, each pair to check m courses,
 then to wrap the answer same as example given, going over n^2 pairs again.
  like [58,25] also exists when [25, 58] exists. In total, O(m * n + n ^2) time, O(n^2 + m * n) space I assume.



  */
 public static Map<String[], String[]> findPairs(String[][] coursePairs) {
     Map<String, Set<String>> studentCourseMap = new HashMap<>();
     Map<String[], String[]> result = new HashMap<>();
     for (String[] coursesPair : coursePairs) {
         if (!studentCourseMap.containsKey(coursesPair[0])) {
             studentCourseMap.put(coursesPair[0], new HashSet<>());
         }
         studentCourseMap.get(coursesPair[0]).add(coursesPair[1]);
     }

     List<String> students = new ArrayList<>(studentCourseMap.keySet());
     for (int i = 0; i < students.size(); i++) {
         for (int j = i + 1; j < students.size(); j++) {
             String[] key = new String[] { students.get(i), students.get(j) };
             List<String> courses = new ArrayList<>();
             for (String c1 : studentCourseMap.get(key[0])) {
                 if (studentCourseMap.get(key[1]).contains(c1)) {
                     courses.add(c1);
                 }
             }
             String[] value = new String[courses.size()];
             for (int k = 0; k < value.length; k++) {
                 value[k] = courses.get(k);
             }
             result.put(key, value);
         }
     }
     return result;
 }
/*
Pt.2 Given that a is pre-requisite of b, b is pre-requisite of c, what is the mid course?
notice that there is only one order of all courses: a->b->c, therefore mid course is b.

 */

    // 输入{{A, B}, {C, D}, {B, C}, {E, F}, {D, E}, {F, G}}, 输出 D.

        public static char findMediumCourse(char[][] courses) {
            int[] count = new int[26];
            Map<Character, Character> map = new HashMap<>();
            for (char[] course : courses) {
                count[course[0] - 'A']++;
                count[course[1] - 'A']++;
                map.put(course[0], course[1]);
            }
            char start = 'A';
            for (int i = 0; i < 26; i++) {
                if (count[i] == 1) {
                    start = (char) ('A' + i);
                    break;
                }
            }
            int middleCourse = map.keySet().size() / 2;
            while (middleCourse-- > 0) {
                start = map.get(start);
            }
            return start;
        }
/*
PT 3 
Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum. There may be more than one track that includes the same course, but each student follows a single linear track from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.

Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that the students could be taking when they are halfway through their track of courses.

Sample input:
all_courses = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output (in any order):
          ["Data Structures", "Creative Writing", "Databases", "Intro to Computer Science"]

All paths through the curriculum (midpoint *highlighted*):

*Intro to C.S.* -> Graphics
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________
                    |          |
                    | Graphics |
               ---->|__________|
               |                          ______________
____________   |                          |            |
|          |   |    ______________     -->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Complexity analysis variables:

n: number of pairs in the input


 */
public static Set<String> halfWayLessons(String[][] courses) {
    Set<String> result = new HashSet<>();
    Map<String, Integer> inorder = new HashMap<>();
    Map<String, List<String>> graph = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();

    for (String[] course : courses) {
        String source = course[0];
        String des = course[1];
        visited.put(source, false);
        visited.put(des, false);
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        if (!graph.containsKey(des)) {
            graph.put(des, new ArrayList<>());
        }
        graph.get(source).add(des);
        if (!inorder.containsKey(source)) {
            inorder.put(source, 0);
        }
        inorder.put(des, inorder.getOrDefault(des, 0) + 1);
    }

    for (String key : inorder.keySet()) {
        if (inorder.get(key).equals(0)) {
            LinkedList<String> temp = new LinkedList<>();
            temp.add(key);
            help(key, graph, temp, result);
        }
    }

    return result;
}

    public static void help(String start, Map<String, List<String>> graph, List<String> temp, Set<String> result) {
        int size = graph.get(start).size();
        if (size == 0) {
            result.add(temp.get((temp.size() + 1) / 2 - 1));
            return;
        }
        for (int i = 0; i < size; i++) {
            String next = graph.get(start).get(i);
            temp.add(next);
            help(next, graph, temp, result);
            temp.remove(temp.size() - 1);
        }

    }
        public static void main(String[] args) {

            String[][] all_courses = { { "Logic", "COBOL" }, { "Data Structures", "Algorithms" },
                    { "Creative Writing", "Data Structures" }, { "Algorithms", "COBOL" },
                    { "Intro to Computer Science", "Data Structures" }, { "Logic", "Compilers" },
                    { "Data Structures", "Logic" }, { "Creative Writing", "System Administration" },
                    { "Databases", "System Administration" }, { "Creative Writing", "Databases" },
                    { "Intro to Computer Science", "Graphics" } };
            Set<String> result3 = halfWayLessons(all_courses);
            System.out.println("[");
            for (String c : result3) {
                System.out.println(c + ", ");
            }
            System.out.println("]");

            char[][] courses2 = { { 'A', 'B' }, { 'C', 'D' }, { 'B', 'C' }, { 'E', 'F' }, { 'D', 'E' }, { 'F', 'G' } };
            System.out.println(findMediumCourse(courses2));

            String[][] coursePairs = { { "58", "Software Design" }, { "58", "Linear Algebra" }, { "94", "Art History" },
                { "94", "Operating Systems" }, { "17", "Software Design" }, { "58", "Mechanics" },
                { "58", "Economics" }, { "17", "Linear Algebra" }, { "17", "Political Science" }, { "94", "Economics" },
                { "25", "Economics" } };
        Map<String[], String[]> result = findPairs(coursePairs);
        System.out.println("{");
        for (String[] key : result.keySet()) {
            System.out.println("[" + key[0] + ", " + key[1] + "]" + ": [");
            for (String courses : result.get(key)) {
                System.out.println(courses + " ");
            }
            System.out.println("]");
        }
        System.out.println("}");
    }
}