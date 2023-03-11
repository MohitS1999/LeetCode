//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
           if (m < n) return medianOfArrays(m,n,b,a);
           
           int low = 0;
           int high = n;
           
           while (low <= high){
               int cut1 = (low+high) >> 1;
               int cut2 = (m + n + 1)/2 - cut1;
               
               int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1-1];
               int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2-1];
               
               int right1 = (cut1 == n) ? Integer.MAX_VALUE : a[cut1];
               int right2 = (cut2 == m) ? Integer.MAX_VALUE : b[cut2];
               
               if (left1 <= right2 && left2 <= right1){
                   if ((m + n)%2 == 0){
                       return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                   }else{
                       return Math.max(left1,left2);
                   }
               }else if (left1 >  right2){
                   high = cut1 - 1;
               }else{
                   low = cut1 + 1;
               }
               
               
           }
           return 0.0;
    }
}