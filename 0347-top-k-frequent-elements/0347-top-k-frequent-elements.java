class Solution {
    class Info implements Comparable<Info>{
        int ele;
        int count;
        Info(int ele,int count){
            this.ele=ele;
            this.count=count;
        }
        public int compareTo(Info i2){
            if(this.count==i2.count){
                return this.ele-i2.ele;
            }
            return i2.count-this.count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int result[]=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Info> pq=new PriorityQueue<>();
        for(Integer key:map.keySet()){
            pq.add(new Info(key,map.get(key)));
        }
        int m=0;
        while(k>0){
            Info curr=pq.poll();
            result[m]=curr.ele;
            k--;
            m++;
        }
        return result;
    }
}