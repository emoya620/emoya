class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int p : piles){
            right = Math.max(right, p);
        }

        while (left < right){
            int middle = (left + right) / 2;
            int hourSpent = 0;

            for (int p : piles){
                hourSpent += Math.ceil((double) p / middle);
            }

            if (hourSpent <= h){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return right;
    }
}
