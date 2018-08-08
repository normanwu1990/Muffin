public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] input) {
        
            // input.length() guaranteed to be >= 3
        int start = 0;
    	int end = input.length-1;
    	// Keep finding middle element until a peak is found;
        while(start<=end){
        		int middle = (start+end)/2;
        		//middle is a peak
        		if(input[middle-1]<input[middle]&&input[middle]>input[middle+1]){
        			return middle;
        		}
        		// peak must be in the right side
        		if(input[middle-1]<input[middle]&&input[middle]<input[middle+1]){
        			start = middle;
        			continue;
        		}
              //  if(input[middle-1]>input[middle]&&input[middle]>input[middle+1]){
                			end = middle;
                			continue;
                //}
        }
    	return -1;
    }
}
