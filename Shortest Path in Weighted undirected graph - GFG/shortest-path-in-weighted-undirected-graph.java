//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<List<int[]>> adj;
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        adj = new ArrayList<>();
        for (int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        int parent[] = new int[n+1];
        for (int i=1;i<=n;i++) parent[i] = i;
        
        pq.add(new int[]{1,0});
        while (!pq.isEmpty()){
            int ar[] = pq.poll();
            int node = ar[0];
            for (int[] itr:adj.get(node)){
                if (dist[node] + itr[1] < dist[itr[0]]){
                    dist[itr[0]] = dist[node] + itr[1];
                    parent[itr[0]] = node;
                    pq.add(new int[]{itr[0],dist[itr[0]]});
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        if (dist[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        
        int ind = n;
        while (parent[ind] != ind){
            ans.add(ind);
            ind = parent[ind];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
        
    }
}