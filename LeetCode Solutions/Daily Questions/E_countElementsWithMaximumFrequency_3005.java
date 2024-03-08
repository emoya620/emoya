class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (int n : nums){
            if (freq.containsKey(n)){
                freq.put(n, freq.get(n) + 1);
            }
            else{
                freq.put(n, 1);
            }
            max = Math.max(max, freq.get(n));
        }

        int ans = 0;
        for (int val : freq.values()){
            if (val == max){
                ans += max;
            }
        }
        return ans;
    }
}
