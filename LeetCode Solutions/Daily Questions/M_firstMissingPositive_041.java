class Solution {
    public int firstMissingPositive(int[] nums) {
        // Choose and arbitrary replacement value that doesn't fall in the range [1, nums.length + 1]
        int replaceVal = nums.length + 2;

        // For every number in the range [1, nums.length + 1], replace it with the replacement value
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 1 || nums[i] > nums.length){
                nums[i] = replaceVal;
            }
        }

        // For every value that is an index of nums, swap it with the value at that index and mark it as seen
        for (int i = 0; i < nums.length; i++){
            int index = nums[i] - 1;
            if (index >= 0 && index <= nums.length-1){
                int temp = nums[index];
                nums[index] = -1;
                

                if (temp-1 >= 0 && temp-1 <= nums.length-1 && temp-1 != index){
                    nums[i] = temp;
                    i--;
                }
            }
        }

        // Iterate through the array one more time and find the first index that was not visited
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != -1){
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
