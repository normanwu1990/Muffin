/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
	if(k==1) return head;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	
	ListNode nodeBeforeReverse = dummy;
// while there are more than K elements behind nodeBeforeReverse
	while(hasKBehind(nodeBeforeReverse,k)){
		nodeBeforeReverse = reverseNextK(nodeBeforeReverse,k);
}
       return dummy.next;
}

// 1. find the K elements from the head


// 2. reverse the given K elements

// Need to be careful with the head and tail next for the group of K


// the 1st element of the K group, 

// ith, i+1th, ... , i+K-1th element

// (i-1)th -> i+k-1th element,  also ith -> (i+K)th

// 1-2-3-4  -> 4-3-2-1
// 2->1
// begin is the element before the first to reverse. 
// The method should return the pointer to the new end of reversed List
public ListNode reverseNextK(ListNode begin, int k){
	ListNode headOfReversed = begin.next;
	ListNode endOfReversed = begin.next;
	ListNode currToAddToHeadOfReversed = headOfReversed.next;
	endOfReversed.next = null;
ListNode tempNext=null;
	for(int i=1;i<k;i++){
		tempNext = currToAddToHeadOfReversed.next;
		currToAddToHeadOfReversed.next = headOfReversed;
		headOfReversed = currToAddToHeadOfReversed;
		currToAddToHeadOfReversed = tempNext;
}
begin.next = headOfReversed;
endOfReversed.next = tempNext;
return endOfReversed;
}

public boolean hasKBehind(ListNode dummy,int k){
	ListNode element = dummy;
	for(int i=0;i<k;i++){
		element = element.next;
		if(element==null){
			return false;
}
}
return true;
}


}
