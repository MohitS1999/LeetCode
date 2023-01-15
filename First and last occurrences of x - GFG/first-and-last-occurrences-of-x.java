//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> ans;
    ArrayList<Long> find(long arr[], int n, int x)
    {
        ans = new ArrayList<>();
        return binarySearch(arr,n,x);
        
    }
    
    ArrayList<Long> binarySearch(long arr[],int n,int val){
        int low = 0;
        int high = n-1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (arr[mid] > val) high = mid - 1;
            else if (arr[mid] < val) low = mid + 1;
            else{
                int firstInd = mid;
                int lstInd = mid;
                while (firstInd > 0 && arr[firstInd] == val){
                    firstInd--;
                }
                
                if (arr[firstInd] != val) firstInd++;
                
                while (lstInd < n && arr[lstInd] == val){
                    lstInd++;
                }
                lstInd--;
                ans.add((long)firstInd);
                ans.add((long)lstInd);
                return ans;
            }
            
        }
        ans.add((long)-1);
        ans.add((long)-1);
        return ans;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends