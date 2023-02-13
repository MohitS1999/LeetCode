//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Disjoint{
    int rank[];
    int parent[];
    
    public Disjoint(int n){
        rank = new int[n];
        parent = new int[n];
        for (int i=0;i<n;i++) parent[i] = i;
    }
    
    public int findPar(int node){
        if (node == parent[node]) return node;
        return parent[node] = findPar(parent[node]);
    }
    
    public void unionByRank(int u,int v){
        
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        
        if (ulp_u == ulp_v) return;
        
        if (rank[ulp_u] < rank[ulp_v]) parent[ulp_u] = ulp_v;
        else if (rank[ulp_v] < rank[ulp_u]) parent[ulp_v] = ulp_u;
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
        
    }
}

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        Disjoint ds = new Disjoint(V);
        
        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++){
                if (adj.get(i).get(j) == 1) ds.unionByRank(i,j);
            }
        }
        
        int cnt=0;
        for (int i=0;i<V;i++){
            if (ds.parent[i] == i) cnt++;
        }
        return cnt;
    }
};