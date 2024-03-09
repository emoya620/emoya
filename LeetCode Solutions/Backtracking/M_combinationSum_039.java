class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, ans, subset, 0, target);
        return ans;
    }

    public void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> subset, int index, int target){
        if (target == 0) {
            ans.add(new ArrayList(subset));
        } 
        else if (target < 0 || index >= candidates.length) {
            return;
        } 
        else {
            subset.add(candidates[index]);
            dfs(candidates, ans, subset, index, target - candidates[index]);
            subset.remove(subset.get(subset.size() - 1));
            dfs(candidates, ans, subset, index + 1, target);
        }
    }
}
