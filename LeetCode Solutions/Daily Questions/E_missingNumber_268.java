class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length){
            if (nums[index] != index){
                return index;
            }
            index++;
        }
        return index;
    }
}
