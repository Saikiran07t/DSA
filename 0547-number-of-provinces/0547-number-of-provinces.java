class Solution {
    public int findCircleNum(int[][] isConnected) {
        int noOfProvinces=0;
        List<List<Integer>> adjList = new ArrayList<>();
        int n= isConnected.length;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
              for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && i!=j){
                adjList.get(i).add(j);
            }
          }
        }
        
        boolean[] visited = new boolean[n];
        //using BFS
        // for(int i=0;i<n;i++){
        //     if(!visited[i]){
        //         bfs(i,adjList,visited);
        //         noOfProvinces++;
        //     }
        // }
        
        //using DFS
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adjList,visited);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
      
    }
    
//     public void bfs(int vertex,List<List<Integer>> adjList,boolean visited[]){
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(vertex);
//         visited[vertex]=true;
        
//         while(!queue.isEmpty()){
//             int cur=queue.poll();
//             for(int neighbor : adjList.get(cur)){
//                 if(!visited[neighbor]){
//                     visited[neighbor]=true;
//                     queue.add(neighbor);   
//                 }
//             }
//         }
//     }
    
    public void dfs(int vertex,List<List<Integer>> adjList,boolean[] visited){
        visited[vertex]=true;
        List<Integer> neighbors = adjList.get(vertex);
        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                dfs(neighbor,adjList,visited);
            }
        }
    }
}