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
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
     boolean seenA = false;
     boolean seenB = false;
     
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root==null) return null;
        return findLCA(root,A,B);
    }
    
    // The obeservation is: if one is in left, another in right, then this root is the answer.
    // if they are found in one side, then whatever found is the answer.
    public TreeNode findLCA(TreeNode root,TreeNode A,TreeNode B){
        if(root==null) return null;
        if(A.val==root.val||B.val==root.val){
            return root;
        }
        TreeNode leftAns = findLCA(root.left,A,B);
        TreeNode rightAns = findLCA(root.right,A,B);
        if(leftAns!=null&&rightAns!=null) return root;
        if(leftAns!=null) return leftAns;
        if(rightAns!=null) return rightAns;
        
        return null;
            
    }
    
}
