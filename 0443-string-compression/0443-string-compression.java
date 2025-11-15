class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
            sb.append(chars[i]);
            int count=1;
            while(i<n-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            
            if(count>1){
                sb.append(count);
            }
        }
        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}