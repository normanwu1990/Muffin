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
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p==null){
            return null;
        }
        // if p has right child, find smallest element in p.right
        if(p.right!=null){
            TreeNode curr = p.right;
            while(curr.left!=null){
                curr = curr.left;
            }
            return curr;
        }
        // if p doesn't have right child, find the root's next biggest element by comparing node val with p.val
        else{
            int target = p.val;
            TreeNode curr = root;
            TreeNode ans = null;
            while (curr!=null){
                // if p is larger than curr, go check right
                if(target>curr.val){
                    curr = curr.right;
                }
                // if p is smaller than curr, go check left
                else if(target<curr.val){
                    ans = curr;
                    curr = curr.left;
                }
                else{
                    return ans;
                }
            }
            return ans;
        }
    }
}
