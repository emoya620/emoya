class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9){
            digits[digits.length - 1]++;
            return digits;
        }
        
        int[] ans = new int[digits.length + 1];
        ans[digits.length] = 0;

        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
            ans[i+1] = 0;

            i--;
        }

        ans[0] = 1;
        return ans;
    }
}
