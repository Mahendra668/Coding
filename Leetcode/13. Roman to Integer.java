class Solution {
    public int romanToInt(String s) {
        // Create a map for Roman numeral values
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;
        
        int result = 0;
        int n = s.length();
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            int current = values[s.charAt(i)];
            int next = (i + 1 < n) ? values[s.charAt(i + 1)] : 0;
            
            // If current < next, it's a subtractive case (IV, IX, XL, XC, CD, CM)
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }
        
        return result;
    }
}
