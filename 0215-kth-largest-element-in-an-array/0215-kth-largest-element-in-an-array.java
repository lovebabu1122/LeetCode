class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] cpy = new int[nums.length];
        System.arraycopy(nums, 0, cpy, 0, nums.length);
        Arrays.sort(cpy);
        int x=0;
        for(int i=0;i<nums.length-k+1;i++){
            x=cpy[i];
        }
        return x;
    }
}