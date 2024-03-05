class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            left = 0;
            right = s.length() - 1;
            if (s.charAt(left) != s.charAt(right) || s.length() == 0){
                break;
            }

            while (left < right && s.charAt(left) == s.charAt(left+1)){
                left++;
            }
            left++;

            while (right > left && s.charAt(right) == s.charAt(right-1)){
                right--;
            }
            right--;

            if (left > right){
                return 0;
            }

            s = s.substring(left, right+1);
        }
        return s.length();
    }
}
