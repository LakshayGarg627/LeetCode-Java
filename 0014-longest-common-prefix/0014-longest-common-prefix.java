class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder("");
        String a=strs[0];
        String b=strs[strs.length-1];
        int len=Math.min(a.length(),b.length());
        for(int i=0;i<len;i++){
            if(a.charAt(i)==b.charAt(i)){
                sb.append(a.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}