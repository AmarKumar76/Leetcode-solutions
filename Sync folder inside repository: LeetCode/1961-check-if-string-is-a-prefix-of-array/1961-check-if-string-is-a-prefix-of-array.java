class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(sb.length()<s.length()){
            sb.append(words[i]);
            }
        }
        System.out.println(sb);
        // String st = sb.subString(0,s.length()-1);
        if(s.equals(sb.toString())){
            return true;
        }
        return false;
        
    }
}