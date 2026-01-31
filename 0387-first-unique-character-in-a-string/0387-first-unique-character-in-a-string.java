class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        Queue<Character> q=new LinkedList<>();
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            
        }
        for(int i=0;i<s.length();i++){
            if(!q.isEmpty() && s.charAt(i)==q.peek()){
                return i;
            }
        }
        return -1;
    }
}