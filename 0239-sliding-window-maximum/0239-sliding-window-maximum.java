class Solution {
    static class Info implements Comparable<Info>{
        int index;
        int value;
        Info(int index,int val){
            this.index=index;
            this.value=val;
        }
        @Override
        public int compareTo(Info i2){
            if(i2.value==this.value){
                return this.index-i2.index;
            }
            return i2.value-this.value;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int result[]=new int[n-k+1];
        TreeSet<Info> set=new TreeSet<>();
        for(int i=0;i<k;i++){
            set.add(new Info(i,nums[i]));
        }
        result[0]=set.first().value;
        for(int i=1;i<=n-k;i++){
            set.remove(new Info(i-1,nums[i-1]));
            set.add(new Info(i+k-1,nums[i+k-1]));

            result[i]=set.first().value;
        }
        return result;

    }
}

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         int result[]=new int[n-k+1];
//         Deque<Integer> dq=new ArrayDeque<>();
//         for(int i=0;i<k;i++){
//             while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
//                 dq.pollLast();
//             }
//             dq.addLast(i);
//         }
//         result[0]=nums[dq.peekFirst()];
//         for(int i=k;i<n;i++){
//             while(!dq.isEmpty() && dq.peekFirst()<=i-k){
//                 dq.pollFirst();
//             }
//             while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
//                 dq.pollLast();
//             }
//             dq.addLast(i);
//             result[i-k+1]=nums[dq.peekFirst()];
//         }
//         return result;
//     }
// }

// class Solution {
//     class Info implements Comparable<Info>{
//         int index;
//         int data;
//         Info(int index,int data){
//             this.index=index;
//             this.data=data;
//         }
//         public int compareTo(Info i2){
//             if(this.data==i2.data){
//                 return this.index-i2.index;
//             }
//             return i2.data-this.data;
//         }
//     }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         int result[]=new int[n-k+1];
//         TreeSet<Info> set=new TreeSet<>();
//         for(int i=0;i<k;i++){
//             set.add(new Info(i,nums[i]));
//         }
//         result[0]=set.first().data;
//         for(int i=1;i<=n-k;i++){
//             set.remove(new Info(i-1,nums[i-1]));
//             set.add(new Info(i+k-1,nums[i+k-1]));

//             result[i]=set.first().data;
//         }
//         return result;
//     }
// }


// TLE
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         int result[]=new int[n-k+1];
//         int max=Integer.MIN_VALUE;
//         int smax=Integer.MIN_VALUE;
//         for(int i=0;i<k;i++){
//             if(max<nums[i]){
//                 smax=max;
//                 max=nums[i];
//             }
//             if(smax<nums[i] && max!=nums[i]){
//                 smax=nums[i];
//             }
//         }
//         result[0]=max;
//         for(int i=1;i<=n-k;i++){
//             int add=nums[i+k-1];
//             int remove=nums[i-1];

//             if(remove!=max){
//                 if(add>=max){
//                     max=add;
//                     smax=max;
//                 }else if(add>smax){
//                     smax=add;
//                 }
//             }else{
//                 max=Integer.MIN_VALUE;
//                 smax=Integer.MIN_VALUE;
//                 for(int j=i;j<i+k;j++){
//                     if(nums[j]>max){
//                         smax=max;
//                         max=nums[j];
//                     }else if(nums[j]>smax){
//                         smax=nums[j];
//                     }
//                 }
//             }
            
//             result[i]=max;
//         }
//         return result;
//     }
// }