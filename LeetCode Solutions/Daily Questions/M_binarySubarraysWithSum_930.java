class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0;
        int right;

        int total = 0;
        int sum;
        while (left < nums.length - 1){
            sum = 0;
            right = left;
            while (right < nums.length){
                sum += nums[right];
                if (sum == goal){
                    total += 1;
                }
                right++;
            }
            left++;
        }

        if (nums[nums.length - 1] == goal){
            total++;
        }

        return total;
    }

    /*
    Better Solution

    int psum = 0, res = 0, count[] = new int[nums.length + 1];
    count[0] = 1;
    for (int i : nums){
        psum += i;
        if (psum >= goal){
            res += count[psum - S];
        }
        count[psum++;]
    }
    return res;
    */
}
