class Solution {
    public int firstUniqChar(String s) {
        HashMap < Character, Integer> map = new HashMap<>();
        int x=0;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        for (int j = 0; j < s.length(); j++) {
            if ( map.get(s.charAt(j)) == 1) {
                // x = j;
                return j;
            }
            
        }
        return -1;
    }
}