class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder("");
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(!st.isEmpty()){
                    sb.append('(');
                }
                st.push(ch);
            }else{
                st.pop();
                if(!st.isEmpty()){
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }
}