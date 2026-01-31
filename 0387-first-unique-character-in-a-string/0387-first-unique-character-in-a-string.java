class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        char ch='.';
        for(Character key:map.keySet()){
            if(map.get(key)==1){
                ch=key;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(ch==s.charAt(i)){
                return i;
            }
        }
        return -1;
    }
}