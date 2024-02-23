class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!queue.isEmpty() && stops <= k){
            int size = queue.size();
            while (size-- > 0){
                int[] cur = queue.poll();
                for (int[] neighbour : adj.get(cur[0])){
                    int price = neighbour[1];
                    int neighbourNode = neighbour[0];
                    if (price + cur[1] >= minCost[neighbourNode]){
                        continue;
                    }
                    minCost[neighbourNode] = price + cur[1];
                    queue.offer(new int[]{neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
