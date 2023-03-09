/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //Naive Approach
        // if(head ==null) return head;
        // HashSet<ListNode> set = new HashSet<ListNode>();
        // while(head!=null){
        //     if(set.contains(head)) return head;
        //     set.add(head);
        //     head=head.next;
        // }
        // return null;
        
        //Better Approach
        if(head==null || head.next==null)
            return null;
        ListNode slow=head,fast=head,entry=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                while(slow!=entry){
                    slow=slow.next;
                    entry=entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}