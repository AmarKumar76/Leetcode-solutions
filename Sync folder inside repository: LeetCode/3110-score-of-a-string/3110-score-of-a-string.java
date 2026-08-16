class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int sum =0;
        for(int i=0;i<n-1;i++){
            sum+=Math.abs((int)s.charAt(i)-(int)s.charAt(i+1));
        }
        return sum;
    }
}