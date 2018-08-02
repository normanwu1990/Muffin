public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int len = nums.length;
        if(len==0) return 0;
        int start = 0;
        int end = len-1;
        int curr = start;
        while(start<end){
          
            if(nums[start]<k) { start++;continue;}
            if(nums[end]>=k) {end--;continue;}
            
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;//make start = end
         
            
        }
        while(start<len&&nums[start]<k){
            start++;
        }
        return start;
    }
}
