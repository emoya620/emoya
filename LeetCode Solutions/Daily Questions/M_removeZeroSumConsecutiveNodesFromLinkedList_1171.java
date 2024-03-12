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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int prefixSum = 0;
        HashMap<Integer, ListNode> prefixToNode = new HashMap<>();
        for (ListNode cur = dummy; cur != null; cur = cur.next){
            prefixSum += cur.val;
            if (prefixToNode.containsKey(prefixSum)){
                ListNode prev = prefixToNode.get(prefixSum);
                ListNode toRemove = prev.next;
                int p = prefixSum + (toRemove != null ? toRemove.val : 0);

                while (p != prefixSum){
                    prefixToNode.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }
                prev.next = cur.next;
            }
            else{
                prefixToNode.put(prefixSum, cur);
            }
        }
        return dummy.next;
    }
}
