class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> temp=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            List<Integer> abcd=new ArrayList<>();
            abcd.add(intervals[i][0]);
            abcd.add(intervals[i][1]);

            temp.add(abcd);
        }
        List<Integer> abcd=new ArrayList<>();
        abcd.add(newInterval[0]);
        abcd.add(newInterval[1]);

        temp.add(abcd);
        int newIntervals[][]=new int[temp.size()][2];
        for(int i=0;i<temp.size();i++){
            newIntervals[i][0]=temp.get(i).get(0);
            newIntervals[i][1]=temp.get(i).get(1);
        }
        Arrays.sort(newIntervals,(a,b)->(a[0]-b[0]));
        int start=newIntervals[0][0];
        int end=newIntervals[0][1];
        List<List<Integer>> result1=new ArrayList<>();
        for(int i=1;i<newIntervals.length;i++){
            int s=newIntervals[i][0];
            int e=newIntervals[i][1];
            if(s<=end){
                end=Math.max(end,e);
            }else{
                List<Integer> temp1=new ArrayList<>();
                temp1.add(start);
                temp1.add(end);

                result1.add(temp1);

                start=s;
                end=e;
            }
        }
        List<Integer> temp2=new ArrayList<>();
        temp2.add(start);
        temp2.add(end);

        result1.add(temp2);

        int result2[][]=new int[result1.size()][2];
        for(int i=0;i<result1.size();i++){
            result2[i][0]=result1.get(i).get(0);
            result2[i][1]=result1.get(i).get(1);
        }
        return result2;
    }
}