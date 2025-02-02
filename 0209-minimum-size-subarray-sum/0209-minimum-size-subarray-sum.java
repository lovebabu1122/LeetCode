class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      
        int n = nums.length;
        int start = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int end = 0; end < n; end++) {
            currentSum += nums[end];
            while (currentSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= nums[start]; 
                start++; 
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}