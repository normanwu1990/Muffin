public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        
        // go through all prereq once and count all the incoming degrees.
        int[] needHowManyCourses = new int[numCourses];
        LinkedList<LinkedList<Integer>> dep = new LinkedList<LinkedList<Integer>>();
        for(int i=0;i<numCourses;i++){
            dep.add(new LinkedList<Integer>());
        }
        for(int[] prereq:prerequisites){
            needHowManyCourses[prereq[0]]++;
            dep.get(prereq[1]).add(prereq[0]);
        }
        // go through the freq, put all starting courses in the q
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(needHowManyCourses[i]==0){
                q.add(i);
            }
        }
        // go through the q, add it's child to the q, if the child has been visited, then
        while(!q.isEmpty()){
            int toUpdate = q.remove();
            for(int courseToStudy:dep.get(toUpdate)){
                needHowManyCourses[courseToStudy]--;
                if(needHowManyCourses[courseToStudy]==0){
                    q.add(courseToStudy);
                }
            }
        }
        // if anything not 0 at the end. return false
        for(int req: needHowManyCourses){
            if(req!=0) return false;
        }
        
        
        return true;
    }
}
