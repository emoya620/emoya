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
    public ListNode mergeKLists(ListNode[] lists) {
        int index = 1;
        while (index < lists.length){
            for (int i = 0; i < lists.length - index; i += 2 * index){
                lists[i] = merge(lists[i], lists[i + index]);
            }
            index *= 2;
        }

        return lists.length > 0 ? lists[0] : null;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
