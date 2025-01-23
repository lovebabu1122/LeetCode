class Solution {
    public int removeDuplicates(int[] nums) {
        int x=nums.length;
        if(x==0){
            return 0;
        }
        int index=1;
        for(int i=1;i<x;i++){
            if(nums[i]!=nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}