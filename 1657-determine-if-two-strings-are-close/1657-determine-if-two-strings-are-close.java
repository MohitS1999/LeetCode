

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        
        if (x != y) return false;
        
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        boolean trace[] = new boolean[26]; 
        
        for (char ch:word1.toCharArray()){
            freq1[ch - 'a']++;
            trace[ch - 'a'] = true;
        }
        
        for (char ch:word2.toCharArray()){
            if (!trace[ch - 'a']) return false;
            freq2[ch - 'a']++;
        }
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        
        for (int i=25;i>=0;i--){
            if (freq1[i] != freq2[i]) return false;
        }
        
        return true;
    }
}