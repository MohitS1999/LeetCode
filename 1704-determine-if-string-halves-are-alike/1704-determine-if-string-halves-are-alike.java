class Solution {
    public boolean halvesAreAlike(String s) {
        int vowel1 = 0;
        int vowel2 = 0;
        int n = s.length();
        int half = n/2;
        
        // first half string
        for (int i=0;i<half;i++){
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') vowel1++;
        }
        
         // second half string
        for (int i=half;i<n;i++){
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') vowel2++;
        }
        
        System.out.println(vowel1 +"  "+ vowel2);
        
        return (vowel1 == vowel2) ? true : false;
    }
}