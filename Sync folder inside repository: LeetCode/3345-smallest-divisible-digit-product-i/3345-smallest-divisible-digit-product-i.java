class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int mult = 1;
            int k = n;

            while (k > 0) {
                int rem = k % 10;
                mult *= rem;
                k /= 10;
            }

            if (mult % t == 0) {
                return n;
            }

            n++;
        }
    }
}