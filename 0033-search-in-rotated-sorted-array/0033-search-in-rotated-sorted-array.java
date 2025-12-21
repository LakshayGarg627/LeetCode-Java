class Solution {
    public int find(int arr[],int start,int end,int target){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;

        if(arr[mid]==target){
            return mid;
        }

        // mid on L1
        if(arr[start]<=arr[mid]){
            if(arr[start]<=target && target<=arr[mid]){
                return find(arr,start,mid,target);
            }else{
                return find(arr,mid+1,end,target);
            }
        }
        // mid on L2
        else{
            if(arr[mid]<=target && target<=arr[end]){
                return find(arr,mid+1,end,target);
            }else{
                return find(arr,start,mid,target);
            }
        }
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        return find(nums,0,n-1,target);
    }
}