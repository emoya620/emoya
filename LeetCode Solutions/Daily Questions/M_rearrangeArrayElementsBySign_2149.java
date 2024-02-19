class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[][] sortedNums = new int[2][nums.length / 2];
        int posIndex = 0;
        int negIndex = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= 0){
                sortedNums[0][posIndex] = nums[i];
                posIndex++;
            }
            else{
                sortedNums[1][negIndex] = nums[i];
                negIndex++;
            }
        }

        int[] ans = new int[nums.length];
        int index = 0;
        posIndex = 0;
        negIndex = 0;
        while (index < nums.length){
            ans[index] = sortedNums[0][posIndex];
            index++;
            ans[index] = sortedNums[1][negIndex];
            index++;
            posIndex++;
            negIndex++;
        }
        return ans;
    }
}
