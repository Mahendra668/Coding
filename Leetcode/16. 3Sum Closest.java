class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        
        // Sort the array to enable two-pointer approach
        Arrays.sort(nums);
        
        // Initialize closest sum with first triplet
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Fix one number, then use two pointers for the other two
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update closest sum if current is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum == target) {
                    // Exact match found, return immediately
                    return currentSum;
                } else if (currentSum < target) {
                    // Need larger sum, move left pointer
                    left++;
                } else {
                    // Need smaller sum, move right pointer
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}
