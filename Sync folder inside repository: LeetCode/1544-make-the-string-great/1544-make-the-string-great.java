class Solution {
    public String makeGood(String s) {
        Stack<Character>st = new Stack<>();
            //st.push(s.charAt(i));
        for(int i=0;i<s.length();i++){
             char ch = s.charAt(i);
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}