/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        // calculate when both head nodes is not null
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode ans = new ListNode(0);
        ListNode ansCurr = ans;
        int carry = 0;
        while(l1!=null&&l2!=null){
            ListNode newDigit = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            ansCurr.next = newDigit;
            ansCurr = ansCurr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry ==0 ){
            if(l1==null){
                ansCurr.next = l2;
                return ans.next;
            }
            if(l2==null){
                ansCurr.next = l1;
                return ans.next;
            }
        }
        else{
            if(l1==null&&l2==null) {
                ansCurr.next = new ListNode(1);
                return ans.next;
            }
            ListNode remain = null;
            if(l1==null) remain = l2;
            if(l2==null) remain = l1;
            while(carry!=0){
                if(remain==null){
                    ansCurr.next = new ListNode(1);
                    return ans.next;
                }
                else{
                    ListNode newDigit = new ListNode((remain.val+1)%10);
                    carry = (remain.val+1)/10;
                    ansCurr.next = newDigit;
                    ansCurr = ansCurr.next;
                    remain = remain.next;
                }
            }
            ansCurr.next = remain;
            return ans.next;
        }
        return null;
        
        // if both are null, create carry, done
        
        // if only one is null, perform carry add to the remaining list
        
        
    }
}
