class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int numOfIslands=0;
        //check for land with'1'
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    
    public void dfs(char[][] grid,int i,int j){
        //base case
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return ;
        }
        if(grid[i][j]=='0') return ; // return as it is water
        grid[i][j]='0'; //else it is land. Mark it as Zero so that it doesnt get counted in future traversal
        //travel in all 4 directions for given land (i.e '1')
        dfs(grid,i+1,j); //towards bottom
        dfs(grid,i-1,j); //towards top
        dfs(grid,i,j+1); //towards right
        dfs(grid,i,j-1); //towards left
    }
}