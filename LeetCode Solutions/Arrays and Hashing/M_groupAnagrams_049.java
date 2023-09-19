class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> anagrams = new ArrayList<>();

        if (strs.length == 0){
            return anagrams;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] keyArr = s.toCharArray();
            Arrays.sort(keyArr);
            String key = new String(keyArr);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }

        anagrams.addAll(map.values());
        return anagrams;
    }
}
