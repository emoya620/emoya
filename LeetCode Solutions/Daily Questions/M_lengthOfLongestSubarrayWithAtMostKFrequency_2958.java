class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        int curLen = 0;
        while (left < nums.length){
            int val = nums[left];
            if (counts.containsKey(val)){
                counts.put(val, counts.get(val) + 1);
            }
            else{
                counts.put(val, 1);
            }

            while (counts.get(val) > k && right < left){
                counts.put(nums[right], counts.get(nums[right]) - 1);
                right++;
                curLen--;
            }

            curLen++;
            left++;
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
