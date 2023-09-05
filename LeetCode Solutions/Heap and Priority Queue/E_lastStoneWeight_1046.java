class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones){
            max.offer(stone);
        }

        while (max.size() > 1){
            int s1 = max.poll();
            int s2 = max.poll();
            max.offer(s1 - s2);
        }

        if (max.size() == 1){
            return max.peek();
        }
        return 0;
    }
}
