public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if(s.length()==0) return true;
        Stack<Character> helper = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                helper.push(c);
            }
            else{
                if(helper.isEmpty()) return false;
                char popOut = helper.pop();
                if(c==')'&&popOut!='(') return false;
                if(c==']'&&popOut!='[') return false;
                if(c=='}'&&popOut!='{') return false;
            }
        }
        
        return helper.isEmpty();
    }
}
