class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if only 1 row, return original string
        if (numRows == 1) {
            return s;
        }
        
        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Place each character in the appropriate row
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction at top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to next row based on direction
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
