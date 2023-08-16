//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
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
         dfs(grid, i-1, j-1);
        dfs(grid, i+1, j+1);
        dfs(grid, i+1, j-1);
        dfs(grid, i-1, j+1);

    }

    
}