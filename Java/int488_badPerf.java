/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    
    public static boolean isNodeFound; 
    
    public TreeNode isNodeFoundInTree(TreeNode root, TreeNode p){
        if(root==null){
            return null;
        }
        TreeNode leftResult; 
        if(root.val>p.val){
            leftResult = isNodeFoundInTree(root.left,p);
            if(leftResult==null&&isNodeFound) return root;
            if(leftResult==null) return null;
            //if(leftResult!=null&&!isNodeFound) return root;
            return leftResult;
        }
        if(root.val==p.val){
            // find the smallest in right subtree;
            isNodeFound = true;
            TreeNode cur = root.right;
            if(cur==null) return null;
            while(cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }
        if(root.val<p.val){
            return isNodeFoundInTree(root.right,p);
        }
        return null;
    }
    // if root>p, the successor could be in left subTree, or it can be root itself
    // if root==p, then return the smallest element in root.right
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null||p==null){
            return null;
        }
        if(p.right!=null){
            TreeNode cur = p.right;
            while(cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }
        isNodeFound=false;
        return isNodeFoundInTree(root,p);
       
    }
}
