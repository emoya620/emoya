/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            head = null;
            return head;
        }
        
        ListNode temp = head;
        ListNode front = head;
        ListNode prev = temp;

        for (int i = 0; i < n; i++){
            front = front.next;
        }

        if (front == null){
            head = head.next;
        }

        while (front != null){
            prev = temp;
            temp = temp.next;
            front = front.next;
        }

        prev.next = temp.next;
        return head;
    }
}
