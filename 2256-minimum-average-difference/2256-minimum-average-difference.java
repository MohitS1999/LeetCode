class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        long sum[] = new long[n];
        sum[0] = nums[0];
        for (int i=1;i<n;i++){
            sum[i] = sum[i-1] + nums[i];
        }
       
        long total_sum = sum[n-1];
        long min_avg = Integer.MAX_VALUE;
        int index = -1;
        long avg = 0;
    
        for (int i=0;i<n;i++){
            long x = sum[i] / (i+1);
            long y = 0;
            if ((n - i - 1) != 0){
                y = (total_sum - sum[i]) / (n - i - 1);
            }
            
            avg = Math.abs(x - y);
            if (min_avg > avg){
                min_avg = avg;
                index = i;
            }
        }
        return index;
    }
}