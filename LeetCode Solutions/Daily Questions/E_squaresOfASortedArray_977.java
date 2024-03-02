class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        int index = nums.length - 1;
        while (index >= 0){
            if (Math.abs(nums[right]) > Math.abs(nums[left])){
                ans[index] = nums[right] * nums[right];
                right--;
            }
            else{
                ans[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return ans;
    }
}
