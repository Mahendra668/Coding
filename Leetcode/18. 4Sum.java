class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Edge case: less than 4 elements
        if (nums == null || n < 4) {
            return result;
        }
        
        // Sort the array to enable two-pointer approach
        Arrays.sort(nums);
        
        // Fix first two numbers, then use two pointers for the other two
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Two pointers for remaining two numbers
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left pointer
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for right pointer
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        // Need larger sum, move left pointer
                        left++;
                    } else {
                        // Need smaller sum, move right pointer
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}
