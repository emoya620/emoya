class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')){
                return false;
            }
            else{
                if (!stack.isEmpty()){
                    if (stack.peek() == '(' && c == ')'){
                        stack.pop();
                    }
                    else if (stack.peek() == '[' && c == ']'){
                        stack.pop();
                    }
                    else if (stack.peek() == '{' && c == '}'){
                        stack.pop();
                    }
                    else{
                        stack.add(c);
                    }
                }
                else{
                    stack.add(c);
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
