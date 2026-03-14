class Solution {
    public boolean isValid(String s) {
        // Use a stack to track opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If closing bracket but stack is empty, invalid
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Check if closing bracket matches the top of stack
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        
        // Valid if all brackets are matched (stack is empty)
        return stack.isEmpty();
    }
}
