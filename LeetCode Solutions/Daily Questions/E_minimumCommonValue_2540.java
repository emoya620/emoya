class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int minVal = -1;

        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] == nums2[index2]){
                minVal = nums1[index1];
                break;
            }
            else if (nums1[index1] < nums2[index2]){
                index1++;
            }
            else{
                index2++;
            }
        }
        return minVal;
    }
}
