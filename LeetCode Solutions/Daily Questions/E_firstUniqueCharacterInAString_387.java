class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }

        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
