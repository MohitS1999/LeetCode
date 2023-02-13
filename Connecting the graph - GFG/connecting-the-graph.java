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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Disjoint{
    int rank[];
    int parent[];

    public Disjoint(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;
    }

    public int findPar(int node){
        if (parent[node] == node) return node;
        return parent[node] = findPar(parent[node]);
    }

    public void unionByRank(int u,int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);

        if (ulp_u == ulp_v) return;

        if (rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }
        else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
}
class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        
        int extraEdges = 0;
        int V = edge.length;
        Disjoint ds = new Disjoint(n);
        
        for (int i=0;i<V;i++){
            
            int u = edge[i][0];
            int v = edge[i][1];
            
            if (ds.findPar(u) == ds.findPar(v)) extraEdges++;
            else ds.unionByRank(u,v);
            
        }
        
        int cntC = 0;
        
        for (int i=0;i<n;i++){
            if (ds.parent[i] == i) cntC++;
        }
        
        int ans = cntC - 1;
        
        return (extraEdges >= ans) ? ans : -1;
        
        
    }
}