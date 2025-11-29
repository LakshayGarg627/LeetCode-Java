class Solution {
    class Info implements Comparable<Info>{
        int data;
        int row;
        int col;
        Info(int data,int row,int col){
            this.data=data;
            this.row=row;
            this.col=col;
        }
        @Override
        public int compareTo(Info i2){
            return this.data-i2.data;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        int n=nums.get(0).size();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            int element=nums.get(i).get(0);
            min=Math.min(min,element);
            max=Math.max(max,element);
            pq.add(new Info(element,i,0));
        }
        int start=min;
        int end=max;
        while(!pq.isEmpty()){
            Info curr=pq.poll();
            min=curr.data;
            if((max-min)<(end-start)){
                start=min;
                end=max;
            }

            if(curr.col+1<nums.get(curr.row).size()){
                int nextval=nums.get(curr.row).get(curr.col+1);
                max=Math.max(max,nextval);
                pq.add(new Info(nextval,curr.row,curr.col+1));
            }else{
                break;
            }
        }
        int result[]=new int[2];
        result[0]=start;
        result[1]=end;
        return result;
    }
}