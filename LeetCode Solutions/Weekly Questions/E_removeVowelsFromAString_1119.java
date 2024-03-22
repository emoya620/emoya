class Solution {
    public String removeVowels(String s) {
        String vowels = "aeiouAEIOU";

        String ans = "";
        for (char c : s.toCharArray()){
            if (vowels.indexOf(c) == -1){
                ans += c;
            }
        }
        return ans;
    }
}
