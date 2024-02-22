class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1){
            return 1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] t : trust){
            if (map.containsKey(t[1])){
                map.put(t[1], map.get(t[1]) + 1);
                set.add(t[0]);
            }
            else{
                map.put(t[1], 1);
                set.add(t[0]);
            }
        }

        for (int key : map.keySet()){
            if (map.get(key) == n-1 && !set.contains(key)){
                return key;
            }
        }
        return -1;
    }
}
