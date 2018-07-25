public class Solution {
    /**
     * @param arr:  an array of non-negative integers
     * @return: minimum number of elements
     */
    public int minElements(int[] arr) {
        List<Integer> intList = new ArrayList<Integer>();
        long sum = 0;
        for (int i : arr)
        {
            intList.add(i);
            sum+=i;
        }
        Collections.sort(intList, Collections.reverseOrder());   
        int ans = 0;
        int topKSum = 0;
        for(int i = 0;i<intList.size();i++){
            topKSum +=intList.get(i);
            if(topKSum>sum/2){
                return i+1;
            }
        }
        return -1;
    }
}
