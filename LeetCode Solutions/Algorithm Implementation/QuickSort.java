// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> quickSortHelper(List<Pair> pairs, int s, int e){
        // Base case
        if (e - s + 1 <= 1){
            return pairs;
        }

        int pivot = pairs.get(e).key;
        int left = s;

        // Move all pairs smaller than pivot to left side of the array
        for (int i = s; i < e; i++){
            if (pairs.get(i).key < pivot){
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
        }

        // Swap the pivot and pair at left index
        Pair pivotPair = pairs.get(e);
        pairs.set(e, pairs.get(left));
        pairs.set(left, pivotPair);

        // Call mergeSortHelper recursively
        quickSortHelper(pairs, s, left - 1);
        quickSortHelper(pairs, left + 1, e);

        return pairs;
    }
}
