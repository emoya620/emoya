class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int[] values = new int[k];
        int i = k-1;
        while (!pq.isEmpty()){
            values[i--] = pq.poll().getKey();
        }
        return values;
    }
}
