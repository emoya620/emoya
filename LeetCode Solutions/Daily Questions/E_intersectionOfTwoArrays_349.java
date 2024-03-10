class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        HashSet<Integer> overlap = new HashSet<>();

        for (int n : nums1){
            overlap.add(n);
        }

        for (int n : nums2){
            if (overlap.contains(n)){
                arr.add(n);
                overlap.remove(n);
            }
        }
        
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
