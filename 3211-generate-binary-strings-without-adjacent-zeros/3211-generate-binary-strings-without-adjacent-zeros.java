class Solution {
    public void helper(int n,int lastIdx,StringBuilder sb,List<String> result){
        if(n==0){
            result.add(sb.toString());
            return;
        }
        helper(n-1,1,sb.append("1"),result);
        sb.deleteCharAt(sb.length()-1);
        if(lastIdx==1){
            helper(n-1,0,sb.append("0"),result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> validStrings(int n) {
        List<String> result=new ArrayList<>();
        helper(n,1,new StringBuilder(""),result);
        return result;
    }
}