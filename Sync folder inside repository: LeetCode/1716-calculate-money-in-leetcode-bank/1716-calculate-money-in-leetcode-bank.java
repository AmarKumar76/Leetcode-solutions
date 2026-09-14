class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int monday = 1;   // is week ka Monday value
        int today = 1;    // aaj ki value
        
        for (int day = 1; day <= n; day++) {
            sum += today;
            
            if (day % 7 == 0) {
                monday++;      // naya hafta shuru, Monday ki value badhao
                today = monday;
            } else {
                today++;       // isi hafte mein agla din, +1
            }
        }
        
        return sum;
    }
}