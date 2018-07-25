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
    
    public int helper(SegmentTreeNode root, int start, int end){
    //    System.out.println("start = "+start+"  End = "+end);
        if(root==null){
            return Integer.MIN_VALUE;
        }
        if(root.start==start&&root.end==end){
            return root.max;
        }
        SegmentTreeNode l = root.left;
        int la = Integer.MIN_VALUE;
        SegmentTreeNode r = root.right;
        int ra = Integer.MIN_VALUE;
        if(start<=(root.start+root.end)/2){
            la = helper(l,start,Math.min(l.end,end));
            if(end>=r.start){
                ra = helper(r,r.start,end);
            }
        }else{
            ra = helper(r,start,end);
        }
        return Math.max(la,ra);
        
    }
    
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        int ans = Integer.MIN_VALUE;
        // write your code here
        if(root==null||end<start){
            return ans;
        }
        end = Math.min(end,root.end);
        start = Math.max(start,root.start);
        return helper(root,start,end);
    }
}
