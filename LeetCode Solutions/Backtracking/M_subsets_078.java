class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        helper(nums, 0, ans, set);
        return ans;
    }

    public void helper(int[] nums, int start, List<List<Integer>> ans, List<Integer> set){
        if (start >= nums.length){
            ans.add(new ArrayList<>(set));
        }
        else{
            set.add(nums[start]);
            helper(nums, start + 1, ans, set);
            set.remove(set.size() - 1);
            helper(nums, start + 1, ans, set);
        }
    }
}
