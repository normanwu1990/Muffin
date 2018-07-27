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
    
    public static int ans;
    
    boolean isUni(TreeNode root){
        System.out.println("ans is: "+ans);
        if(root==null) return false;
        if(root.left==null&&root.right==null){
            ans++;
            return true;
        }
        if(root.left==null&&root.right.val==root.val){
            boolean ansr = isUni(root.right);
            if(ansr){
                ans++;
            }
            return ansr;
        }
        if(root.right==null&&root.left.val==root.val){
            boolean ansl = isUni(root.left);
            if(ansl){
                ans++;
            }
            return ansl;
        }
      //  if(root.left!=null&&root.right!=null&&root.left.val==root.right.val){
            boolean ansr = isUni(root.right);
            boolean ansl = isUni(root.left);
            if(ansr&&ansl&&root.left.val==root.right.val&&root.val==root.right.val) {ans++; return true;}
            return false;
   
    }
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }
        ans = 0;
        isUni(root);
        return ans;
    }
}
