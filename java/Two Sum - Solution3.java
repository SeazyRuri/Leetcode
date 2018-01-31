class Solution {
    private class entry{
        int key;
        int value;
        public entry(int k,int v){
            key=k;
            value=v;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length,a=0,b=n-1;
        entry[] entrys=new entry[n];
        for(int i=0;i<n;i++){
            entrys[i]=new entry(nums[i],i);
        }
        quickSort(entrys,0,n-1);
        int sum=entrys[a].key+entrys[b].key;
        while(sum!=target){
            if(sum>target)b=b-1;
            else a=a+1;
            sum=entrys[a].key+entrys[b].key;
        }
        a=entrys[a].value;
        b=entrys[b].value;
        if(a>b){
            n=b;
            b=a;
            a=n;
        }
        return new int[]{a,b};
    }
    private void quickSort(entry[] a, int begin, int end) {  
        //  
        int tbegin = begin, tend = end;  
        // 将第一个值作为快排序的分界值  
        entry pivot = a[begin];  
        while (tbegin < tend) {  
            // 如果两个游标没有交集，或者后面一直大于或等于分界值就一直向前移动  
            while (tbegin < tend && a[tend].key >= pivot.key) {  
                --tend;  
            }  
            a[tbegin] = a[tend];  
            // 如果两个游标没有交集，或者前面是小于或等于分界值，就一直向后头移动  
            while (tbegin < tend && a[tbegin].key <= pivot.key) {  
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
}