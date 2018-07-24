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
    
    public String getInt(String s,int start){
        String numStr = "";
        for (int i = start; i < s.length(); i++) {
            char charCheck = s.charAt(i);
            if(Character.isDigit(charCheck)) {
                numStr += charCheck;
            }
            else{
                break;
            }
        }
        return numStr;
    }
    
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    public TreeNode str2tree(String s) {
        int len = s.length();
        Stack<TreeNode> ans = new Stack<TreeNode>();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='-'){
                String nextNumStr = getInt(s,i+1);
                ans.push(new TreeNode(-1*Integer.parseInt(nextNumStr)));
                i = i+nextNumStr.length();
            //    i++;
            }
            else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                String nextNumStr = getInt(s,i);
                ans.push(new TreeNode(Integer.parseInt(nextNumStr)));
                i = i+nextNumStr.length()-1;
            }
            else if(s.charAt(i)=='('){
                ans.push(new TreeNode(s.charAt(i)));
            }
            else if(s.charAt(i)==')'){
                TreeNode lastTreeNode = ans.pop();
                TreeNode secondToLast = ans.pop();
                // only one child
                if(secondToLast.val=='('){
                    TreeNode parent = ans.pop();
                    if(parent.left==null) parent.left = lastTreeNode;
                    else parent.right = lastTreeNode;
                    ans.push(parent);
                }
            }
        }
        
        return ans.pop();
    }
}
