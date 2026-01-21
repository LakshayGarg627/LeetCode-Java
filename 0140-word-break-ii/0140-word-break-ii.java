class Solution {
    class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    Node root=new Node();
   
    public void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;
    }
    public void word(String s,int start,List<String> result,StringBuilder sb){
        if(s.length()==start){
            result.add(sb.toString().trim());
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            String substr=s.substring(start,i);
            if(search(substr)){
                
                sb.append(substr).append(" ");
                word(s,i,result,sb);
                for(int k=0;k<substr.length()+1;k++){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
       
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result=new ArrayList<>();
        root=new Node();
        
        for(int i=0;i<wordDict.size();i++){
            insert(wordDict.get(i));
        }

        word(s,0,result,new StringBuilder(""));
        return result;
    }
}