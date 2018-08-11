class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len==0) return 0;
        boolean[][] isP = new boolean[len][len];
        for(int i=0;i<len;i++){
            isP[i][i] = true;
        }
        for(int i=1;i<len;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                isP[i-1][i] = true;
            }
        }
        for(int i = 2;i<len;i++){
            for(int j = i-2;j>=0;j--){
           //     if(s.getChar(j)!=s.getChar(i)) isP[j][i]=false;
                if(s.charAt(j)==s.charAt(i)&&isP[j+1][i-1]) {
                    isP[j][i]=true;
                }
           //     if(s.getChar(j)==s.getChar(i)&&isP[j+1][i-1]) isP[j][i]=true;
            }
        }
        int ans = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isP[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
