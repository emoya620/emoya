class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int total = nums.length * (nums.length + 1) / 2;

        for (int num : nums){
            sum += num;
        }
        return total - sum;
    }
}
