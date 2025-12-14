class Solution {
    public boolean palindrome(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString().equals(str);
    }
    public void helper(String s,List<List<String>> result,List<String> temp,int idx,StringBuilder sb){
        if(idx==s.length()){
            if(sb.length()==0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        sb.append(s.charAt(idx));
        if(palindrome(sb.toString())){
            temp.add(sb.toString());
            helper(s,result,temp,idx+1,new StringBuilder());
            temp.remove(temp.size()-1);
        }
        helper(s,result,temp,idx+1,sb);
        sb.deleteCharAt(sb.length()-1);


    }
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        helper(s,result,new ArrayList<>(),0,new StringBuilder(""));
        return result;
    }   
}