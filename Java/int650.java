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
    
    boolean isLeaf(TreeNode t){
        return t.left==null&&t.right==null;
    }
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null){
            return ans;
        }
        helper(root,ans);
        return ans;
    }
    
    public int helper(TreeNode t, List<List<Integer>> ans){
        List<Integer> toAdd ;
        if(isLeaf(t)){
            if(ans.size()==0){
                toAdd = new LinkedList<Integer>();
                toAdd.add(t.val);
                ans.add(toAdd);
            }
            else{
                ans.get(0).add(t.val);
            }
            
            return 0;
        }
        else{
            int levelRet = 0;
            int leftLevel = 0;
            int rightLevel = 0;
            if(t.left!=null){
                leftLevel = helper(t.left,ans)+1;
            }
            if(t.right!=null){
                rightLevel = helper(t.right,ans)+1;
            }
            levelRet = Math.max(leftLevel,rightLevel);
            if(ans.size()==levelRet){
                toAdd = new LinkedList<Integer>();
                toAdd.add(t.val);
                ans.add(toAdd);
            }
            else{
                ans.get(levelRet).add(t.val);
            }
            return levelRet;
        }
    }
}
