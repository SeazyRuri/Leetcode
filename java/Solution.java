class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[]  newN=new int[nums.length];
        System.arraycopy(nums, 0, newN, 0, nums.length);
        quickSort(nums,0,nums.length-1);
        int key=0;
        int a=-1;
        int b=-1;
        for(int i = 0; i < nums.length;i++){
            key = target - nums[i];
            b=binarySearch(nums,key,i+1);
            if (b == -1)continue;
            else {
                a=i;
                break;
            }
        }
        return new int[]{a,b};
    }
    private void quickSort(int[] a, int begin, int end) {  
        //  
        int tbegin = begin, tend = end;  
        // 将第一个值作为快排序的分界值  
        int pivot = a[begin];  
        while (tbegin < tend) {  
            // 如果两个游标没有交集，或者后面一直大于或等于分界值就一直向前移动  
            while (tbegin < tend && a[tend] >= pivot) {  
                --tend;  
            }  
            a[tbegin] = a[tend];  
            // 如果两个游标没有交集，或者前面是小于或等于分界值，就一直向后头移动  
            while (tbegin < tend && a[tbegin] <= pivot) {  
                ++tbegin;  
            }  
            a[tend] = a[tbegin];  
  
        }  
        // 将临界值赋值给游标的交集的地方  
        a[tbegin] = pivot;  
        if (begin < tend) {  
            // 递归排序游标的左边  
            quickSort(a, begin, tend - 1);  
        }  
        if (tbegin < end) {  
            // 递归排序游标的右边  
            quickSort(a, tbegin + 1, end);  
        }  
  
    } 
    
    private int binarySearch(int[] a,int key,int from){
        int lo=from,hi=a.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid])hi=mid-1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}