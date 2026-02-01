class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        int n=s.length();
        for(int i=0;i<n;i++){
            
            int left=i;
            int right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            String palindrome=s.substring(left+1,right);
            if(palindrome.length()>ans.length()){
                ans=palindrome;
            }
        
            left=i;
            right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            palindrome=s.substring(left+1,right);
            if(palindrome.length()>ans.length()){
                ans=palindrome;
            }
            
        }
        return ans;
    }
}

// class Solution {
//     public String longestPalindrome(String s) {
//         String ans="";
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             int left=i;
//             int right=i;
//             while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
//                 left--;
//                 right++;
//             }
//             String palindrome=s.substring(left+1,right);
//             if(palindrome.length()>ans.length()){
//                 ans=palindrome;
//             }

//             left=i;
//             right=i+1;
//              while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
//                 left--;
//                 right++;
//             }
            
//             palindrome=s.substring(left+1,right);
//             if(palindrome.length()>ans.length()){
//                 ans=palindrome;
//             }
//         }
//         return ans;
//     }
// }

// BRUTE FORCE

// class Solution {
//     public boolean palindrome(String s){
//         int i=0;
//         while(i<s.length()/2){
//             if(s.charAt(i)!=s.charAt(s.length()-i-1)){
//                 return false;
//             }
//             i++;
//         }
//         return true;
//     }
//     public String longestPalindrome(String s) {
//         int size=0;
//         String ans="";
//         for(int i=0;i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//                if(palindrome(s.substring(i,j+1))){
//                     if(size<j-i+1){
//                         size=j-i+1;
//                         ans=s.substring(i,j+1);
//                     }
//                 }
//             }
//         }

//         return ans;

//     }
// }