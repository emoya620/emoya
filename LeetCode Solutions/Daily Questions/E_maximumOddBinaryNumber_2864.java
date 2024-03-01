class Solution {
    public String maximumOddBinaryNumber(String s) {
        int numOnes = 0;
        for (char c : s.toCharArray()){
            if (c == '1'){
                numOnes++;
            }
        }
        numOnes--;

        String ans = "";
        for (int i = 0; i < numOnes; i++){
            ans += "1";
        }

        for (int i = 0; i < s.length() - numOnes - 1; i++){
            ans += "0";
        }
        ans += "1";

        return ans;
    }
}
