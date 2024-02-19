class Solution {
    public boolean isPowerOfTwo(int n) {
        int power = 0;
        while (Math.pow(2, power) <= n){
            if (Math.pow(2, power) == n){
                return true;
            }
            power++;
        }
        return false;
    }
}
