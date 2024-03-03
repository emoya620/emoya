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
    public String gameResult(ListNode head) {
        ListNode even = head;
        ListNode odd = head.next;
        int evenScore = 0;
        int oddScore = 0;

        while (even != null && odd != null){
            if (even.val > odd.val){
                evenScore++;
            }
            else{
                oddScore++;
            }
            
            even = even.next.next;

            if (even == null){
                break;
            }
            odd = odd.next.next;
        }

        if (evenScore > oddScore){
            return "Even";
        }
        else if (oddScore > evenScore){
            return "Odd";
        }
        else{
            return "Tie";
        }
    }
}
