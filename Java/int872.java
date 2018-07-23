public class Solution {
    /**
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return: a list of PIDs of processes that will be killed in the end
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Write your code here
        //create map from parent to child
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int len = pid.size();
        for(int i=0;i<len;i++){
            if(map.containsKey(ppid.get(i))){
                map.get(ppid.get(i)).add(pid.get(i));
            }
            else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(pid.get(i));
                map.put(ppid.get(i),list);
            }
        }
        List<Integer> ans = new LinkedList<Integer>();
        //find the map value for kill, and keep adding kill's childs and loop 
        Queue<Integer> toKill = new LinkedList<Integer>();
        toKill.add(kill);
        while(!toKill.isEmpty()){
            int curr = toKill.remove();
            ans.add(curr);
            if(map.containsKey(curr)){
                toKill.addAll(map.get(curr));
            }
        }
        return ans;
        
        
    }
}
