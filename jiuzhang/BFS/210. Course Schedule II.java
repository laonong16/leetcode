/*
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // initial graph and  in degreee array
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
              graph[i]  = new ArrayList<>();
        for(int[] edge : prerequisites) {
            degree[edge[1]]++;
            graph[edge[0]].add(edge[1]);
        }
        //find  all  the vertex of indegree = 0 and  put it to a queue
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                que.offer(i);
            }
        }
        // BFS  traverse the  graph  and put the  degree 0 course to the result list
        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()) {
            int course = que.poll();
            list.add(course);
            // all the course  dependency couses  degreee  -1
            for(int neighbor : graph[course]) {
                degree[neighbor]--;
                if(degree[neighbor] == 0) {
                    que.offer(neighbor);
                }
            }
            
        }
        if(list.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i = numCourses - 1; i>=0; i--){
            result[numCourses - 1 - i] = list.get(i);
        }
       return result;     
    }
}