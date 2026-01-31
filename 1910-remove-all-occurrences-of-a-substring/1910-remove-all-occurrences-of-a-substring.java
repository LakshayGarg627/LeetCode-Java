class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        int n=part.length();
        int idx=sb.indexOf(part);
        while(idx!=-1){
            sb.delete(idx,idx+n);
            idx=sb.indexOf(part);
        }
        return sb.toString();
    }
}

// class Solution {
//     public String removeOccurrences(String s, String part) {
//         StringBuilder sb=new StringBuilder(s);
//         int n=part.length();
//         while(sb.length()>n){
//             boolean removed=false;
//             for(int i=0;i<sb.length()-n+1;i++){
//                 String substr=sb.substring(i,i+n);
//                 if(substr.equals(part)){
//                     sb.delete(i,i+n);
//                     removed=true;
//                     break;
//                 }
//             }
//             if(!removed){
//                 break;
//             }
//         }
//         if(sb.toString().equals(part)){
//             return "";
//         }
//         return sb.toString();
//     }
// }