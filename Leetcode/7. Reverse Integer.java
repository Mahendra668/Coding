class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            // Extract last digit
            int digit = x % 10;
            
            // Check for overflow BEFORE multiplying by 10
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            
            // Build reversed number
            rev = rev * 10 + digit;
            
            // Remove last digit from x
            x /= 10;
        }
        
        return rev;
    }
}
