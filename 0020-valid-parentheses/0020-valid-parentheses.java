class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
           if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isValidPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '{' && close == '}') || 
               (open == '[' && close == ']');
    }
}