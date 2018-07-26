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
 
 // analysis. BST: sorted if in order traversed
 // sum a+b = n 
 // if root.val <n/2 ? try root+any number in it's right tree;
 // if root.val >n/2 ? try root+any number in it's left tree;
 // What if root is not used? one number from left, one number from right...
 

public class Solution {
    
    public int[] helper(TreeNode root,int n,Set<Integer> seen){
        if(root==null){
            return null;
        }
        if(seen.contains(n-root.val)){
            return new int[]{root.val,n-root.val};
        }
        else{
            seen.add(root.val);
        }
        int[] ansl = helper(root.left,n,seen);
        int[] ansr = helper(root.right,n,seen);
        if(ansl!=null){
            return ansl;
        }if(ansr!=null){
            return ansr;
        }
        return null;
        
    }
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        Set<Integer> seen = new HashSet<Integer>();
        return helper(root,n,seen);
    }
}
