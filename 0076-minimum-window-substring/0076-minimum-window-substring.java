class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n==0 || m==0 || n<m){
            return "";
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=0;
        int minLen=Integer.MAX_VALUE;
        int startIdx=-1;
        int left=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>0){
                count++;
            }
            map.put(ch,map.getOrDefault(ch,0)-1);
            while(count==m){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIdx=left;
                }
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
                if(map.get(s.charAt(left))>0){
                    count--;
                }
                left++;
            }
        }
        if(startIdx==-1){
            return "";
        }
        return s.substring(startIdx,startIdx+minLen);


    }
}