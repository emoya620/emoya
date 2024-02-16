class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int n : arr){
            if (map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }
            else{
                map.put(n, 1);
            }
            set.add(n);
        }

        int numVals = 1;
        while (k > 0 && k >= numVals){
            int[] removed = new int[set.size()];
            int i = 0;
            for (int key : set){
                if (k - numVals < 0 || k == 0){
                    break;
                }
                
                if (map.get(key) == numVals){
                    map.remove(key);
                    removed[i] = key;
                    i++;
                    k -= numVals;
                }
            }

            for (int key : removed){
                if (set.contains(key)){
                    set.remove(key);
                }
            }
            numVals++;
        }
        
        return set.size();
    }
}
