// TC- O(n)
class Solution {
    public void reverse(int nums[]){
        int n=nums.length;
        for(int i=0;i<n/2;i++){
            int temp=nums[i];
            nums[i]=nums[n-i-1];
            nums[n-i-1]=temp;
        }
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pivot=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            reverse(nums);
            return;
        }
        for(int i=n-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                swap(nums,i,pivot);
                break;
            }
        }
        // Reversing the array from pivot+1 to n
        int i=pivot+1;
        int j=n-1;
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }

        
        
    }
} 
// This code is not optimized and giving tle  O(n!)
// class Solution {
//     public void perm(List<Integer> temp,int idx,int n,Set<List<Integer>> result){
//         if(idx==n){
//             result.add(new ArrayList<>(temp));   
//             return;
//         }
//         for(int i=idx;i<n;i++){
//             swap(temp,idx,i);
//             perm(temp,idx+1,n,result);
//             swap(temp,idx,i);
//         }
//     }
//     public void swap(List<Integer> temp,int idx,int i){
//         int c=temp.get(idx);
//         temp.set(idx,temp.get(i));
//         temp.set(i,c);
//     }
//     public void nextPermutation(int[] nums) {
//         int n=nums.length;
//         List<Integer> temp=new ArrayList<>();
//         for(int i=0;i<nums.length;i++){
//             temp.add(nums[i]);
//         }
//         List<Integer> original=new ArrayList<>(temp);
//         Set<List<Integer>> uniquePerms = new HashSet<>();

//         perm(temp,0,n,uniquePerms);

//         List<List<Integer>> result = new ArrayList<>(uniquePerms);

//         result.sort((a, b) -> {
//             for (int i = 0; i < a.size(); i++) {
//                 int diff = a.get(i) - b.get(i);
//                 if (diff != 0) return diff;
//             }
//             return 0;
//         });
//         int idx=0;
//         for(int i=0;i<result.size();i++){
//             if(result.get(i).equals(original)){
//                 idx=i;
//                 break;
//             }
//         }
//         if (idx == result.size() - 1) idx = 0;
//         else idx++;

//         List<Integer> next = result.get(idx);
//         for (int i = 0; i < n; i++) nums[i] = next.get(i);

//     }
// }