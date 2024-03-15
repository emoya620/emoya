class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> meetings = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for (int[] m : intervals){
            meetings.offer(m);
        }

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        int minRooms = 0;
        while (!meetings.isEmpty()){
            int[] m = meetings.poll();
            while (!endTimes.isEmpty() && m[0] >= endTimes.peek()){
                endTimes.poll();
            }
            endTimes.offer(m[1]);
            minRooms = Math.max(minRooms, endTimes.size());
        }
        return minRooms;
    }
}
