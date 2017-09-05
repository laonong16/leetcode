/*
261.Graph Valid Tree
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to check whether these edges make up a valid tree.
Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.+

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
*/
public class Solution {
	pubic boolean validTree(int n, int[][] edges) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		boolean[] visited = new boolean[];
		// build the  vertex to vertex map
		for(int[] edge : edges) {
			map.get(edges[0]).add(edges[1]);
			map.get(edges[1]).add(edges[0]);
		}
		// BFS
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);
		while(!que.isEmpty()) {
			int  curV = que.poll();
			if(visited[curV]) {  // check if there is cycle
				return false;
			}
			visited[curV] = true;
			for(int temp: map.get(curV)) {
				que.offer(temp);
			}
		}
		for(boolean b : visited) {// check if  more than one connected component
			if(!b) {
				return false;
			}
		}
		return true;
	}
}