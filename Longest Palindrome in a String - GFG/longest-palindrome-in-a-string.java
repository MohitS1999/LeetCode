//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
       
       int start = 0;
       int end = 0;
       int len = 0;
       
       for (int i=0;i<s.length();i++){
           
            int lenEven = usingTwoPointer(s,i,i+1);
            int lenOdd = usingTwoPointer(s,i,i);
            
            len = Math.max(lenEven,lenOdd);
            
            if ((end - start) + 1 < len){
                start = i - (len - 1)/2;
                end = i + (len/2);
            }
    
        }    
        if (end - start == 0)return s.substring(0,1);
        return s.substring(start,end+1);
    }
    private static int usingTwoPointer(String s,int i,int j){
        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        
        return j - i - 1;
        
    }
}