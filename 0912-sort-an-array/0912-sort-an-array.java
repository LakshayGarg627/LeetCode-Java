class Solution {
    public void mergeSort(int nums[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);

        merge(nums,start,mid,end);
    }
    public void merge(int nums[],int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int temp[]=new int[end-start+1];
        int k=0;
        while(i<=mid && j<=end){
            if(nums[i]>=nums[j]){
                temp[k++]=nums[j++];
            }else{
                temp[k++]=nums[i++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=end){
            temp[k++]=nums[j++];
        }
        for(k=0,i=start;k<temp.length;k++,i++){
            nums[i]=temp[k];
        }

    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        mergeSort(nums,0,n-1);
        return nums;

    }
}