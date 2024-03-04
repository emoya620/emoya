class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length < 1){
            return 0;
        }
        
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;

        while (left <= right || power >= tokens[left]){
            if (power >= tokens[left]){
                power -= tokens[left];
                score++;
                left++;
            }
            else if (score > 0 && left + 1 < right){
                power += tokens[right];
                score--;
                right--;
            }
            else{
                break;
            }

            if (left > right){
                break;
            }
        }
        return score;
    }
}
