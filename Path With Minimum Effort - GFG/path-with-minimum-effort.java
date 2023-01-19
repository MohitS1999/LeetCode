//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    int dir[][] = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    int MinimumEffort(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        
        int distance[][] = new int[m][n];
        for (int i=0;i<m;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
        distance[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        pq.offer(new int[]{0,0,0});
        
        while (!pq.isEmpty()){
            
            int ar[] = pq.poll();
            int dist = ar[0];
            int x = ar[1];
            int y = ar[2];
            
            if (x == m-1 && y == n-1) return dist;
            
            for (int d[]:dir){
                
                int row = x + d[0];
                int col = y + d[1];
                
                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                
                int abs_dist = Math.max(Math.abs(mat[row][col] - mat[x][y]),dist);
                
                if (abs_dist < distance[row][col]){
                    distance[row][col] = abs_dist;
                    pq.offer(new int[]{abs_dist,row,col});
                }
                
            }
            
        }
        return 0;
    }
}