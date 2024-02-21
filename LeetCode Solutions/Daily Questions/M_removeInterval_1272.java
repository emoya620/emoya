class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> answer = new ArrayList<>();
        int left = toBeRemoved[0];
        int right = toBeRemoved[1];

        for (int[] interval : intervals){
            int curLeft = interval[0];
            int curRight = interval[1];
            if (curLeft < left){
                answer.add(Arrays.asList(curLeft, Math.min(curRight, left)));
            }

            if (curRight > right) {
                answer.add(Arrays.asList(Math.max(right, curLeft), curRight));
            }
        }
        return answer;
    }
}
