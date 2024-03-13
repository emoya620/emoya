class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.val = value;
        this.next = null;
    }
}

class HashTable {
    private int size;
    private int capacity;
    private Node[] table;

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    private int hash(int key){
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = this.hash(key);
        Node node = this.table[index];

        if (node == null){
            this.table[index] = new Node(key, value);
            this.size++;
        }
        else{
            Node prev = null;
            while (node != null){
                if (node.key == key){
                    node.val = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
            this.size++;
        }

        if ((double) this.size / this.capacity >= 0.5){
            this.resize();
        }
    }

    public int get(int key) {
        int index = this.hash(key);
        Node node = this.table[index];

        while (node != null){
            if (node.key == key){
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = this.hash(key);
        Node node = this.table[index];
        Node prev = null;

        while (node != null){
            if (node.key == key){
                if (prev != null){
                    prev.next = node.next;
                }
                else{
                    this.table[index] = node.next;
                }
                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        int newCapacity = this.capacity * 2;
        Node[] newTable = new Node[newCapacity];

        for (Node node : this.table){
            while (node != null){
                int index = node.key % newCapacity;
                if (newTable[index] == null){
                    newTable[index] = new Node(node.key, node.val);
                }
                else{
                    Node newNode = newTable[index];
                    while (node.next != null){
                        newNode = newNode.next;
                    }
                    newNode.next = new Node (node.key, node.val);
                }
                node = node.next;
            }
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }
}
