class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int nsr[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int curr=heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=curr){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        st=new Stack<>();
        int nsl[]=new int[n];
        for(int i=0;i<n;i++){
            int curr=heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=curr){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        int area[]=new int[n];
        for(int i=0;i<n;i++){
            area[i]=(nsr[i]-nsl[i]-1)*heights[i];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<area[i]){
                max=area[i];
            }
        }
        return max;
    }
}


// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n=heights.length;
//         int nsr[]=new int[n];
//         Stack<Integer> s=new Stack<>();
//         for(int i=n-1;i>=0;i--){
//             int curr=heights[i];
//             while(!s.isEmpty() && heights[s.peek()]>=curr){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nsr[i]=n;
//             }else{
//                 nsr[i]=s.peek();
//             }
//             s.push(i);
//         }
//         s=new Stack<>();
//         int nsl[]=new int[n];
//         for(int i=0;i<n;i++){
//             int curr=heights[i];
//             while(!s.isEmpty() && heights[s.peek()]>=curr){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nsl[i]=-1;
//             }else{
//                 nsl[i]=s.peek();
//             }
//             s.push(i);
//         }

//         int area[]=new int[n];
//         for(int i=0;i<n;i++){
//             area[i]=(nsr[i]-nsl[i]-1)*heights[i];
//         }
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             max=Math.max(max,area[i]);
//         }
//         return max;
//     }
// }
