class Solution {
    public int helper(int nums[],int ele){
        List<Integer> indices=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele){
                indices.add(i);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=indices.size()-3;i++){
            int a=indices.get(i);
            int b=indices.get(i+1);
            int c=indices.get(i+2);

            int sum=Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
            min=Math.min(sum,min);
        }

        return min;

    }
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        if(n<3){
            return -1;
        }
        int temp[]=new int[101];
        for(int i=0;i<n;i++){
            temp[nums[i]]++;
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<101;i++){
            if(temp[i]>=3){
                min=Math.min(min,helper(nums,i));
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
        
        // List<Integer> temp1=new ArrayList<>();
        // for(int i=0;i<101;i++){
        //     if(temp[i]>=3){
        //         temp1.add(i);
        //     }
        // }
        // if(temp1.size()==0){
        //     return -1;
        // }
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<temp1.size();i++){
        //     min=Math.min(min,helper(nums,temp1.get(i)));

        // }
        // return min;

    }
}