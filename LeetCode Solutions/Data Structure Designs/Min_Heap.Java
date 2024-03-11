class MinHeap {
    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 1 && heap.get(i) < heap.get(i/2)){
            int temp = heap.get(i);
            heap.set(i, heap.get(i/2));
            heap.set(i/2, temp);
            i /= 2;
        }
    }

    public Integer pop() {
        if (heap.size() == 1){
            return -1;
        }
        if (heap.size() == 2){
            return heap.remove(heap.size() - 1);
        }

        int res = heap.get(1);

        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;
        while (i * 2 < heap.size()){
            if (2 * i + 1 < heap.size() 
            && heap.get(2 * i + 1) < heap.get(2 * i)
            && heap.get(i) > heap.get(2 * i + 1)){
                int temp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, temp);
                i = 2 * i + 1;
            }
            else if (heap.get(i) > heap.get(2 * i)){
                int temp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, temp);
                i *= 2;
            }
            else{
                break;
            }
        }
        return res;
    }

    public Integer top() {
        if (heap.size() == 0 || heap.size() == 1){
            return -1;
        }
        else {
            return heap.get(1);
        }
    }

    public void heapify(List<Integer> nums) {
        if (nums.size() == 0){
            return;
        }

        nums.add(nums.get(0));

        heap = nums;
        int cur = (heap.size() - 1) / 2;
        while (cur > 0) {
            // Percolate Down
            int i = cur;
            while (2 * i < heap.size()) {
                if (2 * i + 1 < heap.size() &&
                heap.get(2 * i + 1) < heap.get(2 * i) &&
                heap.get(i) > heap.get(2 * i + 1)) {
                    // Swap right child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i + 1));
                    heap.set(2 * i + 1, tmp);
                    i = 2 * i + 1;
                } else if (heap.get(i) > heap.get(2 * i)) {
                    // Swap left child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i));
                    heap.set(2 * i, tmp);
                    i = 2 * i;
                } else {
                    break;
                }
            }
            cur--;
        }
        return;
    }
}
