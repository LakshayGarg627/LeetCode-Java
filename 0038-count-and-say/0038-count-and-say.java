class Solution {
    public String compression(String s){
        StringBuilder sb=new StringBuilder("");
        int n=s.length();
        for(int i=0;i<n;i++){
            int count=1;
            while(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                i++;
                count++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder("1");
        n--;
        while(n>0){
            sb=new StringBuilder(compression(sb.toString()));
            n--;
        }
        return sb.toString();
    }
}