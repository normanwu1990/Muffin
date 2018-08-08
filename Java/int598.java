public class Solution {
    class Cell{
        int x;
        int y;
        Cell(int x,int y){
            this.x = x;
            this.y=y;
        }
    }
    
    
    Cell updateCell(int x, int y, int zombieAge, int xlimit, int ylimit, int[][] c){
        if(x<0||y<0||x>=xlimit||y>=ylimit){
            return null;
        }
        if(c[x][y]!=0) return null;
        c[x][y] = zombieAge-1;
        return new Cell(x,y);
    }
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // convert people to zombie,make people -1: one day ,-2,-3,-4,-5
        int lenx = grid.length;
        if(lenx==0) return -1;
        int leny = grid[0].length;
        if(leny==0) return -1;
        Queue<Cell> q = new LinkedList<Cell>();
        for(int i=0;i<lenx;i++){
            for(int j=0;j<leny;j++){
                if(grid[i][j]==1) {
                    grid[i][j] = -1;
                    q.add(new Cell(i,j));
                }
            }
        }
        
        // until no more nodes to look
        while(!q.isEmpty()){
            Cell curr = q.remove();
            int currVal = grid[curr.x][curr.y];
            Cell c = updateCell(curr.x-1,curr.y,currVal,lenx,leny,grid);
            if(c!=null) q.add(c);
            c = updateCell(curr.x+1,curr.y,currVal,lenx,leny,grid);
            if(c!=null) q.add(c);
            c = updateCell(curr.x,curr.y-1,currVal,lenx,leny,grid);
            if(c!=null) q.add(c);
            c = updateCell(curr.x,curr.y+1,currVal,lenx,leny,grid);
            if(c!=null) q.add(c);
        }
        int ans = 1;
        // visit grid, see if there is more 0, also what's the smallest number on grid.
        for(int i=0;i<lenx;i++){
            for(int j=0;j<leny;j++){
                if(grid[i][j]==0) return -1;
                ans = Math.min(ans,grid[i][j]);
            }
        }
        
        // return -1 if has 0, return -(smallestNumber)
        return -(ans+1);
    
    }
}
