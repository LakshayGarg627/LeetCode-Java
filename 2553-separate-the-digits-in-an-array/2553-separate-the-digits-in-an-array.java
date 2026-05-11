class Solution {
    public int[] separateDigits(int[] nums) {
    int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int temp=nums[i];
            while(temp>0){
                int rem=temp%10;
                count++;
                temp/=10;
            }
        }
        int newarr[]=new int[count];
        
        int k=0;
        for(int i=0;i<n;i++){
            int temp=nums[i];
            int count1=0;
            int temparr[]=new int[10]   ;
            while(temp>0){
                temparr[count1++]=temp%10;
                temp=temp/10;

            }
            for(int j=count1-1;j>=0;j--){
              newarr[k++]=temparr[j];
            }
        }
        return newarr;
}

}
