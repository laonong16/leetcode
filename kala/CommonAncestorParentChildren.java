import java.util.*;

/*
Pt. 1 Suppose we have some input data describing a graph of relationships between parents
and children over multiple generations. The data is formatted as a list of (parent, child) pairs,
where each individual is assigned a unique integer identifier.
For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
parentChildPairs = [  (1, 3), (2, 3), (3, 6), (5, 6),
                   (5, 7), (4, 5), (4, 8), (8, 10)  ]
Write a function that takes this data as input and returns two collections:
 one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.
findNodesWithZeroAndOneParents(parentChildPairs) =>
                                  [ [1, 2, 4],    // Individuals with zero parents
                                  [5, 7, 8, 10] // Individuals with exactly one parent ]

O(n) time, O(n) space

 */
class CommonAncestorParentChildren {
    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][]{{1, 3},{2, 3},{3, 6},{5, 6},
                {5, 7},{4, 5},{4, 8},{8, 10}  };
        System.out.println(commonAncestor1(parentChildPairs));
        System.out.println(commonAncestor2(parentChildPairs, 5,8));
        System.out.println(commonAncestor2(parentChildPairs, 1,3));
    }

    public static List<List<Integer>> commonAncestor1(int[][] pairs) {
        // assume non-empty input 2-d array, and each pair contains 2 elements with parent-child order
        List<Integer> zero_ancestor = new ArrayList<>();
        List<Integer> one_ancestor = new ArrayList<>();
        Map<Integer, Integer> ancesterMap = new HashMap<>();
        for (int[] pair : pairs) {
            ancesterMap.put(pair[1], ancesterMap.getOrDefault(pair[1], 0) + 1);
            ancesterMap.put(pair[0], ancesterMap.getOrDefault(pair[0], 0));
        }
        for (int node : ancesterMap.keySet()) {
            if (ancesterMap.get(node) == 0) zero_ancestor.add(node);
            if (ancesterMap.get(node) == 1) one_ancestor.add(node);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zero_ancestor);
        ans.add(one_ancestor);
        return ans;
    }
/*
Pt.2 Write a function that takes the graph, as well as two of the individuals in our dataset,
 as its inputs and returns true if and only if they share at least one ancestor.
Sample input and output: （input as same as last part）
hasCommonAncestor(parentChildPairs, 3, 8) => false
hasCommonAncestor(parentChildPairs, 5, 8) => true
hasCommonAncestor(parentChildPairs, 6, 8) => true
hasCommonAncestor(parentChildPairs, 1, 3) => false
 O(n) time, O(n)
 */
public static boolean commonAncestor2(int[][] pairs, int node1, int node2){
    Set<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
    help_commonAncestor2(p1, node1, pairs);
    help_commonAncestor2(p2, node2, pairs);
    for(int parent : p1){
        if(p2.contains(parent)) return true;
    }
    return false;
}
    public static void help_commonAncestor2(Set<Integer> parents, int node, int[][] pairs){
        for(int[] pair : pairs){
            if(pair[1] == node){
                parents.add(pair[0]);
                help_commonAncestor2(parents, pair[0], pairs);
            }
        }
    }
/*
Pt.3 For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4
Write a function that, for a given individual in our dataset, returns their earliest known ancestor
 -- the one at the farthest distance from the input individual. . check 1point3acres for more.
If there is more than one ancestor tied for "earliest", return any one of them. If the input individual
 has no parents, the function should return null (or -1). Sample input and output:
parent_child_pairs = [ (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5), (4, 8), (8, 10), (11, 2) ]

findEarliestAncestor(parentChildPairs, 8) => 4
findEarliestAncestor(parentChildPairs, 7) => 4
findEarliestAncestor(parentChildPairs, 6) => 11
findEarliestAncestor(parentChildPairs, 1) => null or -1

 */
}