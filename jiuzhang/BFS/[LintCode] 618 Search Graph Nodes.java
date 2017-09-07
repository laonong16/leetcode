/*
[LintCode] 618 Search Graph Nodes

Description
Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target, return NULL if you can't find.

There is a mapping store the nodes' values in the given parameters.

Notice
It's guaranteed there is only one available solution


Example
2------3 - 5
 \        |     |
   \      |     |
     \    |     |
       \  |     |
         1 -- 4
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:
Value of node 1 is 3
Value of node 2 is 4
Value of node 3 is 10
Value of node 4 is 50
Value of node 5 is 50

Return node 4
*/
class Solution {
	public UndirectedGraphNode(List<UndirectedGraphNode> graph, Map<UndirectedGraphNode,Integer> values,
								UndirectedGraphNode node, int target) {
		if(graph == null) {
			return null;
		}
		Queue<UndirectedGraphNode> que = new LinkedList<>();
		Set<UndirectedGraphNode> visited = new HashSet<>();
		que.offer(node);
		set.add(node);
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				UndirectedGraphNode curNode = que.poll();
				if(map.get(curNode) == target) {
					return curNode;
				}
				for(UndirectedGraphNode temp : curNode.neighbors) {
					if(!set.contians(temp)) {
						set.add(temp);
						que.offer(temp);
					}
				}
			}
		}
		return null;
	}
}

//followup  how to get all  closest?
// use list<UndirectedGraphNode> and add  to list