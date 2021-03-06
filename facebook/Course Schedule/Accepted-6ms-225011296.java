// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Course Schedule
// https://leetcode.com/problems/course-schedule/
// 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> neighbors = new HashMap<>();
        int[] indegree = new int[numCourses];
        int count = 0;
        for(int[] dep : prerequisites) {
            int end = dep[0];
            int start = dep[1];
            if (!neighbors.containsKey(start)) {
                neighbors.put(start, new ArrayList<>());
            }
        
            neighbors.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i < numCourses;i++) {
            if(indegree[i] == 0) {
                que.offer(i);
            }
        }
        while(!que.isEmpty()) {
            Integer cur = que.poll();
            count++;
            if(neighbors.get(cur) == null) continue;
            for(Integer tmp : neighbors.get(cur)) {
               indegree[tmp]--;
                if (indegree[tmp] == 0) {
                    que.offer(tmp);
                }
               
            }
        }
        return count == numCourses ;
    }
}

