class Solution {
    public int countCollisions(String directions) {
        int n=directions.length();
        int i=0;
        int j=n-1;
        int result=0;
        while(i<n && directions.charAt(i)=='L'){
            i++;
        }
        while(j>=0 && directions.charAt(j)=='R'){
            j--;
        }
        for(int a=i;a<=j;a++){
            if(directions.charAt(a)!='S'){
                result++;
            }
        }
        return result;
    }
}


// class Solution {
//     public int countCollisions(String directions) {
//         int n=directions.length();
//         int result=0;
//         Stack<Character> s=new Stack<>();
//         for(int i=0;i<n;i++){
//             char ch=directions.charAt(i);
//             if(ch=='R'){
//                 s.push(ch);
//             }
//             else if(ch=='S'){
//                 while(!s.isEmpty() && s.peek()=='R'){
//                     result++;
//                     s.pop();
//                 }
//                 s.push('S');
//             }
//             else{
//                 if(!s.isEmpty() && s.peek()=='R'){
//                     result+=2;
//                     s.pop();
//                     while(!s.isEmpty() && s.peek()=='R'){
//                         result++;
//                         s.pop();
//                     }
//                     s.push('S');
//                 }else if(!s.isEmpty() && s.peek()=='S'){
//                     result++;
//                     s.pop();
//                     s.push('S');
//                 }else{
//                     s.push('L');
//                 }
                
                
//             }
//         }
//         return result;
//     }
// }