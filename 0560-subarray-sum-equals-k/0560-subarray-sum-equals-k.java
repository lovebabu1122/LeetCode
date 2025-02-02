class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int cursum=0;
        int count=0;
        // int a=0;
        int n=nums.length;
        for (int num : nums) {
            cursum += num;
            if (map.containsKey(cursum - k)) {
                count += map.get(cursum - k);
            }
            map.put(cursum, map.getOrDefault(cursum, 0) +1);
        }
        return count;
    }
}