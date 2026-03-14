class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Use the first string as reference
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Check this character in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If we've reached end of any string OR character doesn't match
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If we complete the loop, first string is the common prefix
        return strs[0];
    }
}
