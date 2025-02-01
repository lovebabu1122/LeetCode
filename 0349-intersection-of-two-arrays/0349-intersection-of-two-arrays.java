class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int count=0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }
        for (int x : nums2) {
            if (set.contains(x)) {
                result.add(x);  
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }
        
        return res;
    }
}