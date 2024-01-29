class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        HashSet<Integer> hset = new HashSet<>();
        for (int n : nums){
            hset.add(n);
        }

        int longest = 1;
        for (int n : nums){
            if (!hset.contains(n - 1)){
                int count = 0;
                while (hset.contains(n)){
                    n++;
                    count++;
                }
                longest = Math.max(count, longest);
            }
            
            if (longest > nums.length / 2){
                break;
            }
        }
        return longest;
    }
}
