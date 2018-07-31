public class Solution {
    
    
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder(strs[0]);
        for(String s:strs){
            if(s.length()==0){
                return "";
            }
            for(int i =0;i<s.length()&&i<sb.length();i++){
                if(s.charAt(i)!=sb.charAt(i)){
                    sb = sb.delete(i,sb.length());
                }
            }
        }
        
        return sb.toString();
    }
}
