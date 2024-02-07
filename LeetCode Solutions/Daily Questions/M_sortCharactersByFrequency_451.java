class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()){
            if (charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            }
            else{
                charCount.put(c, 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> e : charCount.entrySet()){
            pq.add(e);
        }

        String answer = "";
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> e = pq.poll();
            char c = e.getKey();
            int val = e.getValue();
            for (int i = 0; i < val; i++){
                answer += c;
            }
        }
        return answer;
    }
}
