//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class DisjointSet{
    int rank[];
    int parent[];
    public DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];
        
        for (int i=0;i<n;i++) parent[i] = i;
    }
    // find ultimate parent of node
    public int findUPar(int node){
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }
    
    public void unionByRank(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if (ulp_u == ulp_v) return;
        
        if (rank[ulp_u] < rank[ulp_v]) parent[ulp_u] = ulp_v;
        else if (rank[ulp_u] > rank[ulp_v]) parent[ulp_v] = ulp_u;
        else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);
    HashMap<String,Integer> hm = new HashMap<>();
    
    for (int i=0;i<n;i++){
        for (int j=1;j<accounts.get(i).size();j++){
            String mail = accounts.get(i).get(j);
            if (!hm.containsKey(mail)){
                hm.put(mail,i);
            }else{
                ds.unionByRank(i,hm.get(mail));
            }
        }
    }
    
    ArrayList<String>[] mergerMail = new ArrayList[n];
    for(int i=0;i<n;i++) mergerMail[i] = new ArrayList<String>();
    for (Map.Entry<String,Integer> map:hm.entrySet()){
        String mail = map.getKey();
        int ulp = ds.findUPar(map.getValue());
        mergerMail[ulp].add(mail);
    }
    
    List<List<String>> ans = new ArrayList<>();
    
    for (int i=0;i<n;i++){
        if (mergerMail[i].size() == 0) continue;
        Collections.sort(mergerMail[i]);
        List<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for (String itr:mergerMail[i]){
            temp.add(itr);
        }
        ans.add(temp);
    }
    return ans;

  }
}
     