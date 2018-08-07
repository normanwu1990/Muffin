public class Solution {
    
    private boolean isNeighbor(String a,String b){
        int diffCount = 0;
        int len = a.length();
        if(len==0) return false;
        if(a.length()!=b.length()){
            return false;
        }
        while(--len>=0){
            if(a.charAt(len)!=b.charAt(len)){
                diffCount++;
            }
            if(diffCount>1){
                return false;
            }
        }
        return diffCount==1;
    }
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        HashMap<String, Integer> distance = new HashMap<String,Integer>();
        distance.put(start,1);
        dict.add(end);
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        while(!q.isEmpty()&&!distance.containsKey(end)){
            //get the next element
            String curr = q.remove();
            int currDis = distance.get(curr);
            for (Iterator<String> i = dict.iterator(); i.hasNext();) {
                String s = i.next();
                if(distance.containsKey(s)){
                    continue;
                }
                if(isNeighbor(s,curr)){
                    q.add(s);
                    distance.put(s,currDis+1);
                    i.remove();;
                }
            }
        }
        if(!distance.containsKey(end)) return 0;
        return distance.get(end);
    }
}
