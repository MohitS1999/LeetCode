class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!hm.containsKey(target - nums[i])) hm.put(nums[i],i);
            else return new int[]{hm.get(target - nums[i]),i};
        }
        ///return;
        return new int[]{0,0};
    }
}