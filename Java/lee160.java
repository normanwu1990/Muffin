/**
 * Definition for singly-linked list.
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
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
	    if(A==null||B==null) return null;
	    ListNode currA = A;
	    int lenA = 1;
	    while(currA.next!=null){
	    	lenA++;
	    	currA=currA.next;
    	}
    	ListNode currB = B;
    	int lenB = 1;
    	while(currB.next!=null){
    		lenB++;
	    	currB=currB.next;
    	}
    	if(currA!=currB){
    		return null;
        }
// find the difference between lenA and lenB, advance the longer one starting point to meet the shorter one. Iterate with one pointer on each list in parallel.
        currA = A;
        currB=B;
            if(lenA>lenB){
                // move A by lenA-lenB
                for(int i=0;i<lenA-lenB;i++){
                    currA = currA.next;
            }
        }
        else if(lenA<lenB){
                // move B by lenB-lenA
                for(int i=0;i<lenB-lenA;i++){
                    currB = currB.next;
                }
        }
        // compare the pointers. if same, that is the intersection
            while(currB!=null&&currA!=null){
                if(currB==currA) return currB;
                currB=currB.next;
                currA=currA.next;
        }
        return null;


// iterate A, save last Node of A as endA, save A len as lenA


// iterate B, save last Node of B as endB, save B len as lenB

// if endA!=endB -> no intersection return null;

    }
}
