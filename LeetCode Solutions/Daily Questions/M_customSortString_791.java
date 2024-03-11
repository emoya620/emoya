class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> sChars = new HashMap<>();
        for (char c : s.toCharArray()){
            if (sChars.containsKey(c)){
                sChars.put(c, sChars.get(c) + 1);
            }
            else{
                sChars.put(c, 1);
            }
        }

        String ans = "";
        for (char c : order.toCharArray()){
            if (sChars.containsKey(c)){
                while (sChars.get(c) > 0){
                    ans += c;
                    sChars.put(c, sChars.get(c) - 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> e : sChars.entrySet()){
            char c = e.getKey();
            int num = e.getValue();

            while (num > 0){
                ans += c;
                num--;
            }
        }
        return ans;
    }
}
