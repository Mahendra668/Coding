class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }
        
        // Single digit numbers are palindromes
        if (x < 10) {
            return true;
        }
        
        // Numbers ending with 0 are not palindromes (except 0 itself)
        if (x % 10 == 0) {
            return false;
        }
        
        int original = x;
        int reversed = 0;
        
        // Reverse the number
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        // Check if original equals reversed
        return original == reversed;
    }
}
