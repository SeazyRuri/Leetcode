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
        int n=nums.length,a=-1,b=-1;
        entry[] entrys=new entry[n];
        for(int i=0;i<n;i++){
            entrys[i]=new entry(nums[i],i);
        }
        quickSort(entrys,0,n-1);
        for(int i=0;i<n-1;i++){
            b=binarySearch(entrys,target-entrys[i].key,i+1);
            if(b!=-1){
                a=entrys[i].value;
                b=entrys[b].value;
                break;
            }
        }
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
        // ����һ��ֵ��Ϊ������ķֽ�ֵ  
        entry pivot = a[begin];  
        while (tbegin < tend) {  
            // ��������α�û�н��������ߺ���һֱ���ڻ���ڷֽ�ֵ��һֱ��ǰ�ƶ�  
            while (tbegin < tend && a[tend].key >= pivot.key) {  
                --tend;  
            }  
            a[tbegin] = a[tend];  
            // ��������α�û�н���������ǰ����С�ڻ���ڷֽ�ֵ����һֱ���ͷ�ƶ�  
            while (tbegin < tend && a[tbegin].key <= pivot.key) {  
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
    private int binarySearch(entry[] a,int key,int from){
        int lo=from,hi=a.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid].key)hi=mid-1;
            else if (key > a[mid].key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}