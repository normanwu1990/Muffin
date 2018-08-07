/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
 
        LinkedList<Integer> numberList = new LinkedList<Integer>();
 
    
        while(!current.isEmpty()){
            TreeNode head = current.remove();
            numberList.add(head.val);
 
            if(head.left != null){
                next.add(head.left);
            }
            if(head.right!= null){
                next.add(head.right);
            }
 
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<TreeNode>();
                ans.add(0,numberList);
                numberList = new LinkedList<Integer>();
            }
        }
        return ans;
        
    }
}
