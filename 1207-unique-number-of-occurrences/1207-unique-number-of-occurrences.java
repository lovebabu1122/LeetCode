class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int[] freq = new int[arr.length];
        int count=0;
        int j=0;
        for (int i = 0; i < arr.length; i++ ){
            count++;
            if (i == arr.length - 1 || arr[i] != arr[i + 1]){
                freq[j]=count;
                j++;
                count=0;
            }
        }
        for (int i = 0; i < j; i++) {
            for (int k = i + 1; k < j; k++) {
                if (freq[i] == freq[k]) {
                    return false;
                }
            }
        }
        return true;
    }
}