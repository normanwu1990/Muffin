/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s,DirectedGraphNode t) {
        int len = graph.size();
        if(len==0){
            return false;
        }
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        q.add(s);
        while(!q.isEmpty()){
            DirectedGraphNode curr = q.remove();
            if(visited.contains(curr)) continue;
            else{
                visited.add(curr);
                if(curr==t) return true;
                q.addAll(curr.neighbors);
            }
        }
        return false;
    }
}
