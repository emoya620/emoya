class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < numbers.length - 1){
            while (left < right){
                if (numbers[left] + numbers[right] == target){
                    return new int[] {left+1, right+1};
                }

                if (numbers[left] + numbers[right] < target) {
                    break;
                }
                right--;
            }
            left++;
            right = numbers.length - 1;
        }
        return new int[]{};
    }
}
