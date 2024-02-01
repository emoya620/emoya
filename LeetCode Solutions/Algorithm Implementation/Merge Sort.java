// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {

    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int s, int e){
        if (e - s + 1 <= 1){
            return pairs;
        }

        int m = (s + e) / 2;
        mergeSortHelper(pairs, s, m);
        mergeSortHelper(pairs, m+1, e);

        merge(pairs, s, m, e);

        return pairs;
    }

    public void merge(List<Pair> arr, int s, int m, int e){
        List<Pair> left = new ArrayList<>(arr.subList(s, m+1));
        List<Pair> right = new ArrayList<>(arr.subList(m+1, e+1));

        int i = 0;
        int j = 0;
        int k = s;
        while (i < left.size() && j < right.size()){
            if (left.get(i).key <= right.get(j).key){
                arr.set(k, left.get(i));
                i++;
            }
            else{
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            arr.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            arr.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
