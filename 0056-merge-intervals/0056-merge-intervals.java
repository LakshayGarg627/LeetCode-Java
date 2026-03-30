class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int m=intervals[0].length;

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int startTime=intervals[0][0];
        int endTime=intervals[0][1];
        List<List<Integer>> result=new ArrayList<>();
        for(int i=1;i<n;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            if(currStart<=endTime){
                endTime=Math.max(currEnd,endTime);
            }
            else{
                List<Integer> temp=new ArrayList<>();
                temp.add(startTime);
                temp.add(endTime);

                result.add(temp);
                startTime=currStart;
                endTime=currEnd;
            }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(startTime);
        temp.add(endTime);
        result.add(temp);
        int result1[][]=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            result1[i][0]=result.get(i).get(0);
            result1[i][1]=result.get(i).get(1);
        }

        return result1;
    }
}

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         int n=intervals.length;
//         int m=intervals[0].length;
//         Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
//         int start=intervals[0][0];
//         int end=intervals[0][1];
//         List<List<Integer>> result=new ArrayList<>();
//         for(int i=1;i<n;i++){
//             int currStart=intervals[i][0];
//             int currEnd=intervals[i][1];
//             if(currStart<=end){
//                 end=Math.max(end,currEnd);
//             }else{
//                 List<Integer> temp=new ArrayList<>();
//                 temp.add(start);
//                 temp.add(end);
//                 result.add(temp);

//                 start=currStart;
//                 end=currEnd;
//             }
//         }
//         List<Integer> temp=new ArrayList<>();
//         temp.add(start);
//         temp.add(end);

//         result.add(temp);

//         int matrix[][]=new int[result.size()][2];
//         for(int i=0;i<matrix.length;i++){
//             matrix[i][0]=result.get(i).get(0);
//             matrix[i][1]=result.get(i).get(1);
//         }
//         return matrix;

//     }
// }

