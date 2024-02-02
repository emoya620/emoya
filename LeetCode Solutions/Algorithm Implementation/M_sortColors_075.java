class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[]{0, 0, 0};
        for (int n : nums){
            counts[n]++;
        }

        int i = 0;
        for (int n = 0; n < counts.length; n++){
            for (int j = 0; j < counts[n]; j++){
                nums[i] = n;
                i++;
            }
        }
    }
}
