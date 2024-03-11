class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->
            Integer.compare((a[0] * a[0] + a[1] * a[1]),
                            (b[0] * b[0] + b[1] * b[1])));
        
        for (int[] p : points){
            heap.offer(p);
        }
        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++){
            int[] p = heap.poll();
            ans[i][0] = p[0];
            ans[i][1] = p[1];
        }
        return ans;
    }
}
