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
    
    public boolean shallBeRemoved(TreeNode t){
        if(t==null) return true;
        boolean shallRemoveLeft = shallBeRemoved(t.left);
        boolean shallRemoveRight = shallBeRemoved(t.right);
        if(shallRemoveLeft) t.left = null;
        if(shallRemoveRight) t.right = null;
        return shallRemoveLeft&&shallRemoveRight&&(t.val==0);
    }
    /**
     * @param root: the root
     * @return: the same tree where every subtree (of the given tree) not containing a 1 has been removed
     */
    public TreeNode pruneTree(TreeNode root) {
        boolean ans = shallBeRemoved(root);
        if(ans) return null;
        else return root;
    }
}
