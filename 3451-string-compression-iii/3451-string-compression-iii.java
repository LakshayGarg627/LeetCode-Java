class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder("");
        int n=word.length();
        for(int i=0;i<n;i++){
            int count=1;
            while(i<n-1 && word.charAt(i)==word.charAt(i+1)){
                i++;
                count++;
                if(count==9){
                    break;
                }
            }
            sb.append(count);
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}