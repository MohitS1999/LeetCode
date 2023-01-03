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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String first;
    int second;
    public Pair(String first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startWord,1));
        Set<String> set = new HashSet<>();
        for (int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        set.remove(startWord);
        
        while (!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();
            if (word.equals(targetWord)) return steps;
            
            for (int i=0;i<word.length();i++){
                for (char ch='a';ch<='z';ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedString = new String(replacedCharArray);
                    
                    if (set.contains(replacedString)){
                        set.remove(replacedString);
                        q.offer(new Pair(replacedString,steps+1));
                    }
                }
            }
            
        }
        return 0;
        
    }
}