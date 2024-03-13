class Solution {
    public int pivotInteger(int n) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++){
            totalSum += i;
        }

        int sum = 0;
        int x = 1;
        while (sum < totalSum && x <= n){
            sum += x;
            if (sum == totalSum){
                return x;
            }
            totalSum -= x;
            x++;
        }
        return -1;
    }
}
