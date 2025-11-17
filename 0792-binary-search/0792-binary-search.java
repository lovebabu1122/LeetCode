class Solution {
    public int search(int[] nums, int target) {
        int size=nums.length;
        int start=0;
        int end=size-1;
        int mid=(start+end)/2;
        
        while(start<=end){
            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]<target){
                start=mid+1;
            }
            if(nums[mid]>target){
                end=mid-1;
            }
            mid=(start+end)/2;
        }
        return -1;
    }
}