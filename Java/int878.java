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
    public void helper(TreeNode root,List<Integer> ans, int leftOrRight){
        if(root==null){
            return;
        }
        if(leftOrRight==-1){
            ans.add(root.val);
            
            helper(root.left,ans,-1);
            if(root.left==null){
                helper(root.right,ans,-1);
            }else{
                helper(root.right,ans,0);
            }
            return;
        }
        if(leftOrRight==0){
            if(root.left==null&&root.right ==null){
                ans.add(root.val);
                return;
            }
            helper(root.left,ans,0);
            helper(root.right,ans,0);
            return;
        }
        if(leftOrRight==1){
            if(root.left==null&&root.right ==null){
                ans.add(root.val);
                return;
            }
            if(root.right==null){
                helper(root.left,ans,1);
            }
            else{
                helper(root.left,ans,0);
            }
            helper(root.right,ans,1);
            ans.add(root.val);
            return;
        }
    }
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // get all left boundary save to answer
        
        
        // get all leaves save to answer, but maybe not the first leave. If last Left is leave, then not add
        
        
        //get all right, if last
        
        
        
        if(root==null){
            return null;
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(root.val);
        helper(root.left,ans,-1);
        helper(root.right,ans,1);
        return ans;
    }
}
