class Solution {
    class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int count=0;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    Node root=new Node();
    public void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
                curr.count++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        root=new Node();
        for(int i=0;i<n;i++){
            insert(strs[i]);
        }
        StringBuilder ans=new StringBuilder("");
        Node curr=root;
        while(curr.count==1 && curr.eow==false){
            for(int i=0;i<26;i++){
                if(curr.children[i]!=null){
                    ans.append((char)(i+'a'));
                    curr=curr.children[i];
                    break;
                }
            }
        }
        return ans.toString();
    }
}

// class Solution {
//     class Node{
//         Node children[]=new Node[26];
//         boolean eow=false;
//         int count=0;
//         Node(){
//             for(int i=0;i<26;i++){
//                 children[i]=null;
//             }
//         }
//     }
//     Node root=new Node();
//     public void insert(String word){
//         Node curr=root;
//         for(int i=0;i<word.length();i++){
//             int idx=word.charAt(i)-'a';
//             if(curr.children[idx]==null){
//                 curr.children[idx]=new Node();
//                 curr.count++;
//             }
//             curr=curr.children[idx];
//         }
//         curr.eow=true;
//     }
//     public String longestCommonPrefix(String[] strs) {
//         if(strs.length==0){
//             return "";
//         }
//         for(int i=0;i<strs.length;i++){
//             insert(strs[i]);
//         }
//         StringBuilder ans=new StringBuilder("");
//         Node curr=root;
//         while(curr.count==1 && curr.eow==false){
//             for(int i=0;i<26;i++){
//                 if(curr.children[i]!=null){
//                     ans.append((char)(i+'a'));
//                     curr=curr.children[i];
//                     break;
//                 }
//             }
//         }
//         return ans.toString();
//     }
// }


// Best
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         StringBuilder sb=new StringBuilder("");
//         int n=strs.length;
//         for(int i=0;i<strs[0].length();i++){
//             char ch=strs[0].charAt(i);
//             for(int j=1;j<n;j++){
//                 if(i>=strs[j].length() || ch!=strs[j].charAt(i)){
//                     return sb.toString();
//                 }
//             }
//             sb.append(ch);
//         }
//         return sb.toString();
//     }
// }
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