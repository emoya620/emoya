class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)){
            if (n == 1){
                return true;
            }
            set.add(n);
            n = getVal(n);
        }
        return false;
    }

    public int getVal(int n){
        int val = 0;
        while (n != 0){
            val += Math.pow((n % 10), 2);
            n /= 10;
        }
        return val;
    }
}
