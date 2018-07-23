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
        helper(root,ans);
        return ans;
    }
    
    public int helper(TreeNode t, List<List<Integer>> ans){
        if(t==null){
            return 0;
        }
        else{
            List<Integer> toAdd ;
            int levelRet = 0;
            int leftLevel = 0;
            int rightLevel = 0;
            leftLevel = helper(t.left,ans);
            rightLevel = helper(t.right,ans);

            levelRet = Math.max(leftLevel,rightLevel);
            if(ans.size()==levelRet){
                toAdd = new LinkedList<Integer>();
                toAdd.add(t.val);
                ans.add(toAdd);
            }
            else{
                ans.get(levelRet).add(t.val);
            }
            return levelRet+1;
        }
    }
}
