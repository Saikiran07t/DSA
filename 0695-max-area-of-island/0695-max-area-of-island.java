class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int maxArea=0;
        int row=grid.length;
        int col=grid[0].length;
        int[] count= new int[1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    count[0]=0;
                    dfs(grid, i, j,count);
                    maxArea= Math.max(maxArea,count[0]);     
                }
            }
        }
        return maxArea;
    }
        public void dfs(int[][] grid, int i, int j,int[] count){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        if(grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        count[0]++;
        dfs(grid, i+1, j,count);
        dfs(grid, i-1, j,count);
        dfs(grid, i, j+1,count);
        dfs(grid, i, j-1,count);
    }


}