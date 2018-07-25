/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    
    public int helper(SegmentTreeNode root, int index, int value){
        int minInt = Integer.MIN_VALUE;
        int maxInSubTreel = Integer.MIN_VALUE;
        int maxInSubTreer = Integer.MIN_VALUE;
        if(root==null) return minInt;
        if(index<root.start||index>root.end){
            return root.max;
        }
        if(index == root.start && index==root.end ){
            root.max = value;
            return root.max;
        }
     //   else if(index<=(root.start+root.end)/2){
            maxInSubTreel = helper(root.left,index,value);
            
    //    }
     //   else{
            maxInSubTreer = helper(root.right,index,value);
   //     }
        root.max = Math.max(maxInSubTreel,maxInSubTreer);
        return root.max;
    }
    /**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        
        if(root==null) return;
        if(index<root.start||index>root.end){
            return;
        }
        //int m = 
        helper(root,index,value);
        //root.max = Math.max(m,root.max);
        //return root.max;
    }
}
