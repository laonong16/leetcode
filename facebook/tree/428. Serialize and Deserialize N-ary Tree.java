/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null)
            return "";
        List<int[]> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            int[] pair = new int[2];
            pair[0] = node.val;
            pair[1] = node.children.size();
            l.add(pair);
            for (Node child: node.children) {
                q.add(child);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] pair: l) {
            sb.append(pair[0] + "," + pair[1] + " ");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] strings = data.split(" ");
        List<int[]> l = new ArrayList<>();
        for (String s: strings) {
            String[] pair = s.split(",");
            l.add(new int[]{Integer.parseInt(pair[0]), Integer.parseInt(pair[1])});
        }
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(-1, new ArrayList<Node>());
        q.add(root);

        ListIterator<int[]> iter = l.listIterator();
        while (!q.isEmpty()) {
            Node node = q.poll();
            int[] pair = iter.next();
            node.val = pair[0];
            List<Node> children = node.children;
            for (int i = 0; i < pair[1]; i++) {
                Node child = new Node(-1, new ArrayList<>());
                children.add(child);
                q.add(child);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));