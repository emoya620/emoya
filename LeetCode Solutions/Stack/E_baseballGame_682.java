class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> record = new ArrayList<>();

        for (String s : operations){
            if (s.equals("+")){
                int val1 = record.get(record.size() - 1);
                int val2 = record.get(record.size() - 2);
                record.add(val1 + val2);
            }
            else if (s.equals("D")){
                int val = record.get(record.size() - 1);
                record.add(val * 2);
            }
            else if (s.equals("C")){
                record.remove(record.size() - 1);
            }
            else{
                record.add(Integer.parseInt(s));
            }
        }

        int sum = 0;
        for (int n : record){
            System.out.println(n);
            sum += n;
        }
        return sum;
    }
}
