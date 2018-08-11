public class Solution {
    class Position{
        int x;
        int y;
        Position(int a,int b){
            x= a;
            y=b;
        }
    }
    
    public char getNeighbor(char[][] board,int x,int y){
        if(x<0||y<0||x>=board.length||y>=board[0].length){
            return 'X';
        }
        return board[x][y];
    }
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        int lenx =board.length;
        if(lenx==0){
            return;
        }
        int leny =board[0].length;
        if(leny==0){
            return;
        }
        
        Queue<Position> q = new LinkedList<Position>();
        // add O from all edges
        for(int i=0;i<lenx;i++){
            if (board[i][0]=='O'){
                q.add(new Position(i,0));
            }
            if (board[i][leny-1]=='O'){
                q.add(new Position(i,leny-1));
            }
        }
        
        for(int j=0;j<leny;j++){
            if (board[0][j]=='O'){
                q.add(new Position(0,j));
            }
            if (board[lenx-1][j]=='O'){
                q.add(new Position(lenx-1,j));
            }
        }
        
        // visit all element in q and add if more O
        while(!q.isEmpty()){
            Position p = q.remove();
            int curx = p.x;
            int cury = p.y;
            if(board[curx][cury]=='Q'){
                continue;    
            }
            else{
                board[curx][cury]='Q';
                char neighbor = getNeighbor(board,curx-1,cury);
                if(neighbor=='O')
                q.add(new Position(curx-1,cury));
                
                neighbor = getNeighbor(board,curx+1,cury);
                if(neighbor=='O')
                q.add(new Position(curx+1,cury));
                
                neighbor = getNeighbor(board,curx,cury-1);
                if(neighbor=='O')
                q.add(new Position(curx,cury-1));
                
                neighbor = getNeighbor(board,curx,cury+1);
                if(neighbor=='O')
                 q.add(new Position(curx,cury+1));
            }
        }
        
        for(int i=0;i<lenx;i++){
            for(int j=0;j<leny;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='Q'){
                    board[i][j]='O';
                }
            }
        }
        
    }
}
