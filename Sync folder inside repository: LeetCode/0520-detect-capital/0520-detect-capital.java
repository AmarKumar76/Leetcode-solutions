class Solution {
    public boolean detectCapitalUse(String word) {
        // if(word.equals(word.toUpperCase()))
        //     return true;

        // if(word.equals(word.toLowerCase()))
        //     return true;

        // if(Character.isUpperCase(word.charAt(0)) &&
        //    word.substring(1).equals(word.substring(1).toLowerCase()))
        //     return true;

        // return false;

        // another approach

        int u =0;
        int l = 0;
        int n = word.length();
        for(int i=0;i<n;i++){
            if(Character.isUpperCase(word.charAt(i))){
                u++;
            }else{
                l++;
            }
            if(Character.isUpperCase(word.charAt(0)) && l==n-1){
                return true;
            }
        }
        if(u==n){
            return true;
        }
        if(l==n){
            return true;
        }
        return false;
    }
}