class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        int n=digits.length();
        String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,n,0,result,arr,new StringBuilder(""));
        return result;
    }
    public void helper(String digits,int n,int idx,List<String> result,String arr[],StringBuilder sb){
        if(idx==n){
            result.add(sb.toString());
            return;
        }
        int index=digits.charAt(idx)-'0';
        String temp=arr[index];
        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i));
            helper(digits,n,idx+1,result,arr,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}


// class Solution {
//     public List<String> letterCombinations(String digits) {
//         List<String> result=new ArrayList<>();
//         String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

//         helper(digits,result,arr,0,new StringBuilder(""));
//         return result;


//     }
//     public void helper(String digits,List<String> result,String arr[],int idx,StringBuilder sb){
//         if(idx==digits.length()){
//             result.add(sb.toString());
//             return;
//         }
//         int index=digits.charAt(idx)-'0';
//         String temp=arr[index];
//         for(int i=0;i<temp.length();i++){
//             sb.append(temp.charAt(i));
//             helper(digits,result,arr,idx+1,sb);
//             sb.deleteCharAt(sb.length()-1);
//         }
//     }
// }


// class Solution {
//     public List<String> letterCombinations(String digits) {
//         List<String> temp=new ArrayList<>();
//         if(digits==null && digits.length()==0){
//             return temp;
//         }
//         String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//         backtrack(digits,0,arr,temp,new StringBuilder(""));
//         return temp;
//     }
//     public void backtrack(String digits,int index,String arr[],List<String> temp,StringBuilder sb){
//         if(index==digits.length()){
//             temp.add(sb.toString());
//             return;
//         }
//         int idx=digits.charAt(index);
//         String curr=arr[idx-'0'];
//         for(int i=0;i<curr.length();i++){
//             sb.append(curr.charAt(i));
//             backtrack(digits,index+1,arr,temp,sb);
//             sb.deleteCharAt(sb.length()-1);
//         }
//     }
// }

// class Solution {
//     public List<String> letterCombinations(String digits) {
//         List<String> result=new ArrayList<>();
//         if(digits==null || digits.length()==0){
//             return result;
//         }
//         String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//         backtrack(0,digits,arr,new StringBuilder(),result);
//         return result;
//     }
//     public void backtrack(int index,String digits,String arr[],StringBuilder current,List<String> result){
//         if(index==digits.length()){
//             result.add(current.toString());
//             return;
//         }
//         char ch=digits.charAt(index);
//         String temp=arr[ch-'0'];
//         for(int i=0;i<temp.length();i++){
//             current.append(temp.charAt(i));
//             backtrack(index+1,digits,arr,current,result);
//             current.deleteCharAt(current.length()-1);
//         }
//     }
// }