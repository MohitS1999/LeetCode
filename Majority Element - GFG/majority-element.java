//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i<size;i++){
            if (hm.containsKey(a[i])){
                hm.put(a[i],hm.get(a[i])+1);
            }else{
                hm.put(a[i],1);
            }
        }
        int ans = -1;
        
        for (Map.Entry<Integer,Integer> map:hm.entrySet() ){
            if (map.getValue() > size/2) return map.getKey();
        }
        return -1;
    }
}