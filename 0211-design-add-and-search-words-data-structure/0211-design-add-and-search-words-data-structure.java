class WordDictionary {
    WordDictionary children[]=new WordDictionary[26];
    boolean eow=false;

    public WordDictionary() {
        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
    public void addWord(String word) {
        WordDictionary curr=this;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new WordDictionary();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean search(String word){
        return searchUtil(word,0,this);
    }
    public boolean searchUtil(String word,int i,WordDictionary curr) {
        if(curr==null){
            return false;
        }
        if(i==word.length()){
            return curr.eow;
        }
        char ch=word.charAt(i);
        if(ch!='.'){
            return searchUtil(word,i+1,curr.children[ch-'a']);
        }else{
            for(int j=0;j<26;j++){
                if(searchUtil(word,i+1,curr.children[j])){
                    return true;
                }
            }
            return false;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */