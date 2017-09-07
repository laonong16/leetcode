/*
LintCode-Topological Sorting
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice

You can assume that there is at least one topological order in the graph.

Have you met this question in a real interview? Yes
Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        // node ,in-degree map
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode curNode : node.neighbors) {
                if (!map.containsKey(curNode)) {
                    map.put(curNode, 1);
                } else {
                    map.put(curNode, map.get(curNode) + 1);
                }
            }
        }
        Queue<DirectedGraphNode> que = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
           // in degree 0  node put to result and que
            if (!map.containsKey(node)) {
                result.add(node);
                que.offer(node);
            }
        }
        while (!que.isEmpty()) {
            DirectedGraphNode node = que.poll();
            for (DirectedGraphNode curNode : node.neighbors) {
                map.put(curNode, map.get(curNode) - 1); // in digree - 1
                if (map.get(curNode) == 0) {
                    result.add(curNode);
                    que.offer(curNode);
                }
            }
        }
        return result;
    }
}