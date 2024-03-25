class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int ind = Math.abs(nums[i]);
            if (nums[ind - 1] < 0){
                list.add(ind);
            }
            else{
                nums[ind - 1] *= -1;
            }
        }
        return list;
    }
}
