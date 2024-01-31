class ListNode {
    String val;
    ListNode forward;
    ListNode back;

    public ListNode(String val){
        this.val = val;
        forward = null;
        back = null;
    }
}

class BrowserHistory {
    ListNode head;
    ListNode current;

    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
        current = head;
    }
    
    public void visit(String url) {
        current.forward = new ListNode(url);
        current.forward.back = current;
        current = current.forward;
    }
    
    public String back(int steps) {
        while (steps > 0 && current.back != null){
            steps--;
            current = current.back;
        }

        return current.val;
    }
    
    public String forward(int steps) {
        while (steps > 0 && current.forward != null){
            steps--;
            current = current.forward;
        }

        return current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
