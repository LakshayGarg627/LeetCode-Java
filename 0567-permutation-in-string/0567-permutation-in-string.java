class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length()+1;i++){
            String substr=s2.substring(i,i+s1.length());
            int window[]=new int[26];
            for(int j=0;j<substr.length();j++){
                window[substr.charAt(j)-'a']++;
            }
            boolean flag=true;
            for(int j=0;j<26;j++){
                if(window[j]!=freq[j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}
// All permutation based approach - TLE
// class Solution {
//     boolean found=false;
//     public void permutations(StringBuilder sb1,String s2,int n,int idx){
//         if(found)return;
//         if(idx==n){
//             if(s2.contains(sb1.toString())){
//                 found=true;
//             }
//             return;
//         }
//         for(int i=idx;i<n;i++){
//             swap(sb1,idx,i);
//             permutations(sb1,s2,n,idx+1);
//             swap(sb1,idx,i);

//             if(found)return;
//         }
//     }
//     public void swap(StringBuilder sb1,int i,int j){
//         char temp=sb1.charAt(i);
//         sb1.setCharAt(i,sb1.charAt(j));
//         sb1.setCharAt(j,temp);
//     }
//     public boolean checkInclusion(String s1, String s2) {
//         int n=s1.length();
//         permutations(new StringBuilder(s1),s2,n,0);
//         return found;
//     }
// }