/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       if(node ==null) return null;
        //key is original and value is cloned nodes
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node,new Node(node.val,new ArrayList<Node>()));
        
        //traversal using BFS
        while(!queue.isEmpty()){
            Node curr =queue.poll();
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val,new ArrayList<Node>()));
                    queue.add(neighbor);
                    
                }
    Node clonedNode =map.get(curr);
    Node neighborNode = map.get(neighbor);
    clonedNode.neighbors.add(neighborNode);
                
            }
        }
        return map.get(node); //as map stores cloned node address as Value
    }
}