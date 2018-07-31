public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        int base = 1;
        while (n/base > 0) {
            int cur = (n/base)%10;
            int low = n - (n/base) * base;
            int high = n/(base * 10);
            if (cur == k) {
                result += high * base + low + 1;
            } else if (cur < k) {
                result += high * base;
            } else {
                result += (high + 1) * base;
            }
            base *= 10;
        }
        return result;
    }
};
