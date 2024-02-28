class TreeNode {
    int key;
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class TreeMap {
    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);

        if (root == null){
            root = newNode;
            return ;
        }

        TreeNode current = root;
        while (true){
            if (key < current.key){
                if (current.left == null){
                    current.left = newNode;
                    return ;
                }
                current = current.left;
            }
            else if (key > current.key){
                if (current.right == null){
                    current.right = newNode;
                    return ;
                }
                current = current.right;
            }
            else{
                current.val = val;
                return ;
            }
        }
    }

    public int get(int key) {
        TreeNode current = root;
        while (current != null){
            if (key < current.key){
                current = current.left;
            }
            else if (key > current.key){
                current = current.right;
            }
            else{
                return current.val;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNode current = root;
        int minVal = -1;
        while (current != null){
            minVal = current.val;
            current = current.left;
        }
        return minVal;
    }

    public int getMax() {
        TreeNode current = root;
        int maxVal = -1;
        while (current != null){
            maxVal = current.val;
            current = current.right;
        }
        return maxVal;
    }

    public void remove(int key) {
       root = removeHelper(root, key);
    }

    private TreeNode removeHelper(TreeNode cur, int key){
        if (cur == null){
            return null;
        }

        if (key < cur.key){
            cur.left = removeHelper(cur.left, key);
        }
        else if (key > cur.key){
            cur.right = removeHelper(cur.right, key);
        }
        else{
            if (cur.left == null){
                return cur.right;
            }
            else if (cur.right == null){
                return cur.left;
            }
            else{
                TreeNode temp = cur.right;
                while (temp != null && temp.left != null){
                    temp = temp.left;
                }

                TreeNode minNode = temp;
                cur.key = minNode.key;
                cur.val = minNode.val;
                cur.right = removeHelper(cur.right, minNode.key);
            }
        }
        return cur;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal (TreeNode cur, List<Integer> result){
        if (cur != null){
            inorderTraversal(cur.left, result);
            result.add(cur.key);
            inorderTraversal(cur.right, result);
        }
    }
}
