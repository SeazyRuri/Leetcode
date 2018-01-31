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
}