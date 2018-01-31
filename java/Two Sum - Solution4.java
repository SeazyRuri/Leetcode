class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a=-1,b=-1;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(map.get(target-nums[i])==null)
                map.put(nums[i],i);
            else {
                a=map.get(target-nums[i]);
                b=i;
                break;
            }
        }
        return new int[]{a,b};
    }
}