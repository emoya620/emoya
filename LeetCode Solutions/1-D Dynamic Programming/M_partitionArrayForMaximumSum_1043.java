class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int K = k + 1;

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);

        for (int start = n - 1; start >= 0; start--) {
            int curMax = 0;
            int end = Math.min(n, start + k);

            for (int i = start; i < end; i++) {
                curMax = Math.max(curMax, arr[i]);
                dp[start % K] = Math.max(dp[start % K], dp[(i + 1) % K] + curMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}
