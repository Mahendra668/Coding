class Solution {
    // Phone digit to letters mapping
    private static final String[] PHONE_MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    private List<String> result = new ArrayList<>();
    private StringBuilder current = new StringBuilder();
    
    public List<String> letterCombinations(String digits) {
        // Edge case: empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start backtracking from index 0
        backtrack(digits, 0);
        
        return result;
    }
    
    private void backtrack(String digits, int index) {
        // Base case: if we've processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters for current digit
        int digit = digits.charAt(index) - '0';
        String letters = PHONE_MAP[digit];
        
        // Try each letter for this digit
        for (char c : letters.toCharArray()) {
            // Choose: add letter to current combination
            current.append(c);
            
            // Explore: move to next digit
            backtrack(digits, index + 1);
            
            // Unchoose: backtrack (remove last letter)
            current.deleteCharAt(current.length() - 1);
        }
    }
}
