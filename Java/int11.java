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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(root,k1,k2,ans);
        return ans;
        // write your code here
    }
    
    public void helper(TreeNode root, int k1, int k2,List<Integer> ans){
        if(root==null){
            return;
        }
        if(root.val>=k1&&root.val<=k2){
            helper(root.left,k1,k2,ans);
            ans.add(root.val);
            helper(root.right,k1,k2,ans);
            return;
        }
        else {
            if(root.val>k2){
                helper(root.left,k1,k2,ans);
            }
            if(root.val<k1){
                helper(root.right,k1,k2,ans);
            }
            return;
        }
    }
}
