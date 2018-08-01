public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        if(A.length==0) return 0;
        int ans = A[0];
        for(int i = 1;i<A.length;i++){
            ans = ans^A[i];
        }
        return ans;
    }
}
