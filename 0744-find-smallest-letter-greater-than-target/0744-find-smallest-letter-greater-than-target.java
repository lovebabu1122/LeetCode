class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char small='{';
        for(int i=0; i<letters.length;i++){
            
            if(letters[i]>target){
                if(letters[i]<small){
                small=letters[i];
                }
            }
            
        }
        if(small == '{'){
            return letters[0];
        }
        return small;
    }
}