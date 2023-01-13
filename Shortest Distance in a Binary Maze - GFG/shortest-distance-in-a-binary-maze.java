//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int shortestPath(int[][] grid, int[] source, int[] des) {
        int m = grid.length;
        int n = grid[0].length;
        
        int x = source[0];
        int y = source[1];
        
        if (grid[x][y] == 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        int dist[][] = new int[m][n];
        for (int i=0;i<m;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        
        dist[x][y] = 0;
        q.add(new int[]{x,y,0});
        while (!q.isEmpty()){
            
            int ar[] = q.poll();
            int row = ar[0];
            int col = ar[1];
            int distance = ar[2];
            if (row == des[0] && col == des[1]) return distance;
            
            
            for (int d[]:dir){
                
                int i = row + d[0];
                int j = col + d[1];
                
                if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || dist[i][j] <= distance + 1) continue;
                dist[i][j] = distance + 1;
                q.offer(new int[]{i,j,distance+1});
            }
            
        }
        return -1;
        
        // Your code here
    }
}
