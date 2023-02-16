//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    int rank[];
    int parent[];
    int size[];

    public DisjointSet(int n){

        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        for (int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

    }

    public int findUPar(int node){
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    public void unionByRank(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);


        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else if (rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }

    public void unionBySize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);


        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
class Solution {
    int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    private boolean isValid(int row,int col,int n){
        return row >= 0 && col >= 0 && row < n && col < n;
    }
    
    public int MaxConnection(int grid[][]) {
        
        int m = grid.length;
       
        
        DisjointSet ds = new DisjointSet(m * m);
        //step1
        for (int row=0;row<m;row++){
            for (int col=0;col<m;col++){
                
                if (grid[row][col] == 0) continue;
                for (int d[]:dir){
                    int adjr = row + d[0];
                    int adjc = col + d[1];
                    
                    if (isValid(adjr,adjc,m)){
                        if (grid[adjr][adjc] == 1){
                            int node = row * m + col; 
                            int adjNode = adjr * m + adjc;
                            ds.unionBySize(node,adjNode);
                        }
                    }
                    
                }
                
            }
        }
        //step2
        int cnt = 0;
        
        for (int row=0;row<m;row++){
            for (int col=0;col<m;col++){
                if (grid[row][col] == 1) continue;
                HashSet<Integer> hs = new HashSet<>();
                for (int d[]:dir){
                    int adjr = row + d[0];
                    int adjc = col + d[1];
                    
                    if (isValid(adjr,adjc,m) && grid[adjr][adjc] == 1){
                        hs.add(ds.findUPar(adjr * m + adjc));
                    }
                }
                int sizeTotal = 0;
                for (Integer parents:hs){
                    sizeTotal += ds.size[parents];
                }
                cnt = Math.max(cnt,sizeTotal+1);
            }
        }
        
        for (int cellNo=0;cellNo<m*m;cellNo++){
            cnt = Math.max(cnt,ds.size[ds.findUPar(cellNo)]);
        }
        return cnt;
        
        
    }
    
}