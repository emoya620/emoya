class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;

        for (int[] i : intervals){
            int curStart = i[0];
            int curEnd = i[1];

            if (curEnd < start || inserted){
                ans.add(new int[]{curStart, curEnd});
                continue;
            }

            start = Math.min(start, curStart);
            if (end < curStart){
                ans.add(new int[]{start, end});
                ans.add(new int[]{curStart, curEnd});
                inserted = true;
                continue;
            }

            if (end <= curEnd){
                ans.add(new int[]{start, curEnd});
                inserted = true;
            }
        }

        if (!inserted){
            ans.add(new int[]{start, end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
