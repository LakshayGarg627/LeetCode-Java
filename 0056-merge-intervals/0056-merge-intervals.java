class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int m=intervals[0].length;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<List<Integer>> result=new ArrayList<>();
        for(int i=1;i<n;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            if(currStart<=end){
                end=Math.max(end,currEnd);
            }else{
                List<Integer> temp=new ArrayList<>();
                temp.add(start);
                temp.add(end);
                result.add(temp);

                start=currStart;
                end=currEnd;
            }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(start);
        temp.add(end);

        result.add(temp);

        int matrix[][]=new int[result.size()][2];
        for(int i=0;i<matrix.length;i++){
            matrix[i][0]=result.get(i).get(0);
            matrix[i][1]=result.get(i).get(1);
        }
        return matrix;

    }
}


// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//         int start=intervals[0][0];
//         int end=intervals[0][1];
//         List<List<Integer>> temp=new ArrayList<>();
//         for(int i=1;i<intervals.length;i++){
//             int s=intervals[i][0];
//             int e=intervals[i][1];
//             if(s<=end){
//                 end=Math.max(end,e);
//             }else{
//                 List<Integer> list=new ArrayList<>();
//                 list.add(start);
//                 list.add(end);
//                 temp.add(list);
//                 start=s;
//                 end=e;
//             }
//         }
//         List<Integer> last = new ArrayList<>();
//         last.add(start);
//         last.add(end);
//         temp.add(last);
//         int result[][]=new int[temp.size()][2];
//         for(int i=0;i<temp.size();i++){
//             result[i][0]=temp.get(i).get(0);
//             result[i][1]=temp.get(i).get(1);
//         }
//         return result;
//     }
// }


// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//         int start=intervals[0][0];
//         int end=intervals[0][1];
//         List<int[]> list=new ArrayList<>();
//         for(int i=1;i<intervals.length;i++){
//             int s=intervals[i][0];
//             int e=intervals[i][1];
//             if(s<=end){
//                 end=Math.max(end,e);
//             }else{
//                 list.add(new int[]{start,end});
//                 start=s;
//                 end=e;
//             }
//         }
//         list.add(new int[]{start,end});
//         int result[][]=new int[list.size()][2];
//         for(int i=0;i<list.size();i++){
//             result[i]=list.get(i);
//         }
//         return result;
//     }
// }