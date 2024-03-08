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
    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ListNode temp = head;

        while (temp != null){
            if (freq.containsKey(temp.val)){
                freq.put(temp.val, freq.get(temp.val) + 1);
            }
            else{
                freq.put(temp.val, 1);
            }
            temp = temp.next;
        }

        ListNode newHead = new ListNode(0);
        temp = newHead;
        for (int val : freq.values()){
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return newHead.next;
    }
}
