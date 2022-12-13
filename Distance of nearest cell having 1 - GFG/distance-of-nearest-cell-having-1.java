//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] nearest(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        int ans[][] = new int[m][n];
        
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 1){
                    que.offer(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        
        while (!que.isEmpty()){
            
            int ar[] = que.poll();
            int i = ar[0];
            int j = ar[1];
            int val = ar[2];
            ans[i][j] = val;
            
            for (int[] d:dir){
                int row = i + d[0];
                int col = j + d[1];
                
                if(row < 0 || col < 0 || row >= m || col >= n || vis[row][col]) continue;
                
                que.offer(new int[]{row,col,val+1});
                vis[row][col] = true;
            }
            
        }
        return ans;
    }
    
}