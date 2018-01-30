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
        // ����һ��ֵ��Ϊ������ķֽ�ֵ  
        int pivot = a[begin];  
        while (tbegin < tend) {  
            // ��������α�û�н��������ߺ���һֱ���ڻ���ڷֽ�ֵ��һֱ��ǰ�ƶ�  
            while (tbegin < tend && a[tend] >= pivot) {  
                --tend;  
            }  
            a[tbegin] = a[tend];  
            // ��������α�û�н���������ǰ����С�ڻ���ڷֽ�ֵ����һֱ���ͷ�ƶ�  
            while (tbegin < tend && a[tbegin] <= pivot) {  
                ++tbegin;  
            }  
            a[tend] = a[tbegin];  
  
        }  
        // ���ٽ�ֵ��ֵ���α�Ľ����ĵط�  
        a[tbegin] = pivot;  
        if (begin < tend) {  
            // �ݹ������α�����  
            quickSort(a, begin, tend - 1);  
        }  
        if (tbegin < end) {  
            // �ݹ������α���ұ�  
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