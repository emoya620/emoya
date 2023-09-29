public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder newStr = new StringBuilder();
        for (String s : strs){
            newStr.append(s.length()).append("#").append(s);
        }
        return newStr.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> strs = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int x = i;
            while (s.charAt(x) != '#'){
                x++;
            }

            int length = Integer.valueOf(s.substring(i,x));
            i = x + length + 1;
            strs.add(s.substring(x + 1,i));
        }
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
