class Solution {
public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int row=heights.length;
        int col=heights[0].length;
        
        int[][] pacific = new int[row][col];
        int[][] atlantic = new int[row][col];
        
        //iterate from pacific from top
        for(int i=0;i<row ;i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
        }
        
          //iterate from pacific from left
       for(int j=0;j<col;j++){
           dfs(heights,0,j,Integer.MIN_VALUE,pacific);
       }
        
          //iterate from atlantic from bottom
        for(int i=0;i<row ;i++){
            dfs(heights,i,col-1,Integer.MIN_VALUE,atlantic);
        }
        
        
          //iterate from atlantic from right
       for(int j=0;j<col;j++){
           dfs(heights,row-1,j,Integer.MIN_VALUE,atlantic);
       }
        //check for cells that can flow to both of these oceans
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
             if(pacific[i][j]==1 && atlantic[i][j]==1){
                 List<Integer> cell = new ArrayList<>();
                 cell.add(i);
                 cell.add(j);
                 ans.add(cell);
             }
            }
        }
        return ans;
    }
    
    public void dfs(int[][] heights ,int i,int j,int prev,int[][] ocean){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length){
            return;
        }
        if(ocean[i][j]==1) return ;
        if(heights[i][j]<prev) return;
        ocean[i][j]=1;
        //traverse in all directions
        dfs(heights,i+1,j,heights[i][j],ocean); //bottom
        dfs(heights,i-1,j,heights[i][j],ocean); //top
        dfs(heights,i,j+1,heights[i][j],ocean); //right
        dfs(heights,i,j-1,heights[i][j],ocean); //left
    }
        
}