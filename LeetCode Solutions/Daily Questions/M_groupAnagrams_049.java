class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs){
            int[] key = new int[26];
            for (char c : s.toCharArray()){
                key[c - 'a']++;
            }

            String k = Arrays.toString(key);
            if (map.containsKey(k)){
                List<String> strings = map.get(k);
                strings.add(s);
                map.put(k, strings);
            }
            else{
                List<String> strings = new ArrayList<>();
                strings.add(s);
                map.put(k, strings);
            }
        }

        List<List<String>> answers = new ArrayList<>(map.values());
        return answers;
    }
}
