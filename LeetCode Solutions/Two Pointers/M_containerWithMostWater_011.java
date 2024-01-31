class Solution {
    public int maxArea(int[] height) {
        int maxAmount = 0;

        int left = 0;
        int right = height.length - 1;
        int width;
        while (left < right){
            int index = left;

            while (index < right){
                width = right - index;
                maxAmount = Math.max(maxAmount, width * Math.min(height[index], height[right]));
                index++;
            }
            
            if (height[left] < height[left+1]){
                left++;
            }

            int curRight = height[right];
            while (left < right && curRight >= height[right]){
                right--;
            }
        }
        return maxAmount;
    }
}
