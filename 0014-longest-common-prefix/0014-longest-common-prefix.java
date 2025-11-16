// Best
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder("");
        int n=strs.length;
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<n;j++){
                if(i>=strs[j].length() || ch!=strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
// Sorting-expensive in large tc
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         Arrays.sort(strs);
//         StringBuilder sb=new StringBuilder("");
//         String a=strs[0];
//         String b=strs[strs.length-1];
//         int len=Math.min(a.length(),b.length());
//         for(int i=0;i<len;i++){
//             if(a.charAt(i)==b.charAt(i)){
//                 sb.append(a.charAt(i));
//             }else{
//                 break;
//             }
//         }
//         return sb.toString();
//     }
// }