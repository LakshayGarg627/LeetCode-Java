class Solution {
    public String removeOccurrences(String s, String part) {
        int idx=-1;
        StringBuilder sb=new StringBuilder(s);
        while(true){
            idx=sb.indexOf(part);
            if(idx==-1){
                break;
            }
            sb.delete(idx,idx+part.length());
            
        }
        return sb.toString();
    }
}