class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a = -1, b = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a=i;b=j;break;
                }
            }
            if(a!=-1)break;
        }
        return new int[]{a,b};
    }
}