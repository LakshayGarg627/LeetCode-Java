class Solution {
    class Info{
        String word;
        int step;
        Info(String word,int step){
            this.word=word;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(beginWord,1));
        while(!q.isEmpty()){
            Info curr=q.poll();
            String temp=curr.word;
            int step=curr.step;
            if(temp.equals(endWord)){
                return step;
            }
            for(int i=0;i<temp.length();i++){
                char arr[]=temp.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String word=new String(arr);
                    if(set.contains(word)){
                        q.add(new Info(word,step+1));
                        set.remove(word);
                    }
                    
                }

            }
        }
        return 0;
    }
}

// class Solution {
//     class Pair{
//         String word;
//         int step;
//         Pair(String word,int step){
//             this.word=word;
//             this.step=step;
//         }
//     }
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         HashSet<String> set=new HashSet<>();
//         for(int i=0;i<wordList.size();i++){
//             set.add(wordList.get(i));
//         }
//         Queue<Pair> q=new LinkedList<>();
//         q.add(new Pair(beginWord,1));
//         // set.remove(beginWord);
//         while(!q.isEmpty()){
//             Pair p=q.remove();
//             String temp=p.word;
//             int step=p.step;
//             if(temp.equals(endWord)){
//                 return step;
//             }
//             for(int i=0;i<temp.length();i++){
//                 char arr[]=temp.toCharArray();
//                 for(char ch='a';ch<='z';ch++){
//                     arr[i]=ch;
//                     String str=new String(arr);
//                     if(set.contains(str)){
//                         q.add(new Pair(str,step+1));
//                     }
//                     set.remove(str);
//                 }
//             }
//         }
//         return 0;

//     }
// }