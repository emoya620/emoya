class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int s, int e){
        if (s >= e){
            return;
        }

        int m = (s + e) / 2;
        mergeSort(nums, s, m);
        mergeSort(nums, m + 1, e);

        merge(nums, s, m, e);
    }

    public void merge(int[] nums, int s, int m, int e){
        ArrayList<Integer> arr = new ArrayList<>();

        int i = s;
        int j = m+1;
        while (i <= m && j <= e){
            if (nums[i] <= nums[j]){
                arr.add(nums[i]);
                i++;
            }
            else{
                arr.add(nums[j]);
                j++;
            }
        }

        while (i <= m){
            arr.add(nums[i]);
            i++;
        }

        while (j <= e){
            arr.add(nums[j]);
            j++;
        }

        for (int idx = s; idx <= e; idx++){
            nums[idx] = arr.get(idx - s);
        }
    }
}
