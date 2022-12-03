class Pair{
    char ch;
    int freq;
    public Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        int ar[] = new int[123];
        
        for (char ch:s.toCharArray()){
            ar[(int)ch]++;
        }
        
        List<Pair> list = new ArrayList<>();
        
        for (int i=0;i<123;i++){
            if (ar[i]>0)
                list.add(new Pair((char)i,ar[i]));
        }
        
        Collections.sort(list,(p1,p2) -> -(p1.freq - p2.freq));
        
        String ans = "";
        for (int i=0;i<list.size();i++){
            for (int j = 0;j<list.get(i).freq;j++){
                ans += list.get(i).ch;
            }
        }
        return ans;
    }
}