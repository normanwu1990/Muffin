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
    public int sum(TreeNode root, Set<Integer> map){
        if(root==null){
            return 0;
        }else{
            int ans = sum(root.left,map)+sum(root.right,map)+root.val;
            map.add(ans);
            return ans;
        }
    }
    /**
     * @param root: a TreeNode
     * @return: return a boolean
     */
    public boolean checkEqualTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Set<Integer> map = new TreeSet<Integer>();
        int totalSum = sum(root.left,map)+sum(root.right,map)+root.val;
        return map.contains(totalSum/2);
    }
}
