class Solution {
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        return sb.toString();
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String t = preprocess(s);
        int n = t.length();
        int[] p = new int[n]; 
        int center = 0, right = 0; 
        int maxLength = 0, start = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (p[i] > maxLength) {
                maxLength = p[i];
                start = (i - maxLength) / 2; 
            }
        }

        return s.substring(start, start + maxLength);
    }
    
}