class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows==1 || numRows>=s.length()) return s;

        StringBuilder[]sb = new StringBuilder[numRows];
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        int i = 0;
        boolean down = false;

        for(char ch : s.toCharArray()){
            sb[i].append(ch);
            if(i==0 || i==numRows-1){
                down = !down;
            }
            if(down){
                i++;
            }else{
                i--;
            }
        }
            for(int j=0;j<numRows;j++){
            ans.append(sb[j]);
            }
     return ans.toString();
    }
}