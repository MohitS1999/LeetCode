class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int count[] = new int[fruits.length];
        int curMax = 0;
        int max = 0;
        int typeCount = 0;
        
        for (int i=0;i<fruits.length;i++){
            
            if (count[fruits[i]] == 0) typeCount++;
            count[fruits[i]]++;
            curMax++;
            
            while (typeCount > 2 && start < i){
                count[fruits[start]]--;
                if (count[fruits[start]] == 0) typeCount--;
                start++;
                curMax--;
            }
            
            max = Math.max(max,curMax);
            
        }
        
        return max;
    }
}