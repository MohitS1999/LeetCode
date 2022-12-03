
class Solution {
     public String frequencySort(String s) {

//---create a FreqArray to Store frequency of all Characters in String--//
     
        int []freq=new int[123];
        for(int i=0;i<s.length();i++) {freq[(int)s.charAt(i)]++;}
        
//---create an ArrayList of type pair---//        
        List<pair> q=new ArrayList<>();

//---add elements to the arraylist by creating a new object of pair ---//        
        for(int i=0;i<123;i++){
            if(freq[i]>0){
                q.add(new pair(freq[i],(char)i));
            }
        }
//---sort in descending order--//        
        
        Collections.sort(q,(x,y)->{
            return -(x.val-y.val);
        });
// ---use StringBuilder to crete the resultant String ---//       
       
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q.size();i++){
            int n=q.get(i).val;
            for(int j=0;j<n;j++)sb.append(q.get(i).c);
        }
        return sb.toString();
        }
//--- a class of type pair that holds each character and its frequency in String input--//    
  class pair{
      char c; int val;
      pair(int val,char c){
          this.c=c;
          this.val=val;
      }
  }  
}