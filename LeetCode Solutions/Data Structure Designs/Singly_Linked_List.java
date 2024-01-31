class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this(val, null);
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode cur = head.next;
        int i = 0;
        while (cur != null){
            if (i == index){
                return cur.val;
            }
            i++;
            cur = cur.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null){
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode curr = this.head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        // Remove the node ahead of curr
        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> vals = new ArrayList<>();
        ListNode cur = head.next;
        while (cur != null){
            vals.add(cur.val);
            cur = cur.next;
        } 
        return vals;
    }
}
