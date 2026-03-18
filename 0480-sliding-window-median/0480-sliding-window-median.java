class Solution {
    public double medianCalc(List<Integer> list,int k){
        int n=list.size();
        if(k%2!=0){
            return list.get(n/2)/1.0;
        }
        return ((long)list.get((n-1)/2)+list.get(n/2))/2.0;
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double result[]=new double[n-k+1];
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<k;i++){
            temp.add(nums[i]);
        }
        Collections.sort(temp);
        result[0]=medianCalc(temp,k);
        for(int i=1;i<=n-k;i++){
            int toRemove=nums[i-1];
            int toAdd=nums[i+k-1];

            int removeIdx=Collections.binarySearch(temp,toRemove);
            temp.remove(removeIdx);

            int addIdx=Collections.binarySearch(temp,toAdd);
            if(addIdx<0){
                addIdx=-addIdx-1;
            }
            temp.add(addIdx,toAdd);
            
            result[i]=medianCalc(temp,k);
        }
        return result;
    }
}