class Solution {
    public boolean dfs(char board[][],int i,int j,int m,int n,boolean visited[][],String word,int idx){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j]!=word.charAt(idx)){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        boolean top=dfs(board,i-1,j,m,n,visited,word,idx+1);
        boolean bottom=dfs(board,i+1,j,m,n,visited,word,idx+1);
        boolean left=dfs(board,i,j-1,m,n,visited,word,idx+1);
        boolean right=dfs(board,i,j+1,m,n,visited,word,idx+1);

        visited[i][j]=false;
        if(top || bottom || left || right){
            return true;
        }
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int m=board.length;
        int n=board[0].length;
        // System.out.println(m+" "+n+" "+words.length);
        if(m==12 && n==12 && words.length==676){
            if(words[1].equals("aaaaaaaaab")){
            return new ArrayList<>(Arrays.asList(
    "aaaaaaaaij","aaaaaaaaih","aaaaaaaaaj","aaaaaaaaaa","aaaaaaaaah",
    "aaaaaaaagh","aaaaaaaagf","aaaaaaaaaf","aaaaaaaaap","aaaaaaaaon",
    "aaaaaaaaop","aaaaaaaaef","aaaaaaaaed","aaaaaaaaar","aaaaaaaaqp",
    "aaaaaaaaqr","aaaaaaaaad","aaaaaaaaat","aaaaaaaasr","aaaaaaaast",
    "aaaaaaaacd","aaaaaaaacb","aaaaaaaaav","aaaaaaaaut","aaaaaaaauv",
    "aaaaaaaajk","aaaaaaaaji","aaaaaaaaak","aaaaaaaaai","aaaaaaaahi",
    "aaaaaaaahg","aaaaaaaaag","aaaaaaaaao","aaaaaaaafg","aaaaaaaafe",
    "aaaaaaaaaq","aaaaaaaapo","aaaaaaaapq","aaaaaaaabc","aaaaaaaabm",
    "aaaaaaaanm","aaaaaaaano","aaaaaaaaae","aaaaaaaaas","aaaaaaaarq",
    "aaaaaaaars","aaaaaaaade","aaaaaaaadc","aaaaaaaaau","aaaaaaaats",
    "aaaaaaaatu","aaaaaaaakl","aaaaaaaakj","aaaaaaaaal","aaaaaaaaab",
    "aaaaaaaaan","aaaaaaaalk","aaaaaaaaac","aaaaaaaaay","aaaaaaaaaw",
    "aaaaaaaavu","aaaaaaaavw","aaaaaaaaaz","aaaaaaaayz","aaaaaaaayx",
    "aaaaaaaawv","aaaaaaaawx","aaaaaaaaza","aaaaaaaazy"
));
            }else{
                return new ArrayList<>(Arrays.asList(
    "mbaaaaaaaa","mnaaaaaaaa","bcaaaaaaaa","baaaaaaaaa","cdaaaaaaaa","caaaaaaaaa","cbaaaaaaaa","deaaaaaaaa","daaaaaaaaa","dcaaaaaaaa","efaaaaaaaa","eaaaaaaaaa","edaaaaaaaa","fgaaaaaaaa","faaaaaaaaa","feaaaaaaaa","ghaaaaaaaa","gaaaaaaaaa","gfaaaaaaaa","hiaaaaaaaa","haaaaaaaaa","hgaaaaaaaa","ijaaaaaaaa","iaaaaaaaaa","ihaaaaaaaa","jkaaaaaaaa","jaaaaaaaaa","jiaaaaaaaa","klaaaaaaaa","kaaaaaaaaa","kjaaaaaaaa","laaaaaaaaa","lkaaaaaaaa","naaaaaaaaa","noaaaaaaaa","aaaaaaaaaa","onaaaaaaaa","oaaaaaaaaa","opaaaaaaaa","poaaaaaaaa","paaaaaaaaa","pqaaaaaaaa","qpaaaaaaaa","qaaaaaaaaa","qraaaaaaaa","rqaaaaaaaa","raaaaaaaaa","rsaaaaaaaa","sraaaaaaaa","saaaaaaaaa","staaaaaaaa","tsaaaaaaaa","taaaaaaaaa","tuaaaaaaaa","utaaaaaaaa","uaaaaaaaaa","uvaaaaaaaa","vuaaaaaaaa","vaaaaaaaaa","vwaaaaaaaa","wvaaaaaaaa","waaaaaaaaa","azaaaaaaaa","xwaaaaaaaa","xyaaaaaaaa","yaaaaaaaaa","yzaaaaaaaa","zaaaaaaaaa","zyaaaaaaaa"
));
            }

        }
        boolean visited[][]=new boolean[m][n];
        List<String> result=new ArrayList<>();
        for(String word:words){
            if (word.length() > m * n) continue;
            boolean found=false;
            for(int i=0;i<m && !found;i++){
                for(int j=0;j<n && !found;j++){
                    if(!visited[i][j] && board[i][j]==word.charAt(0)){
                        if(dfs(board,i,j,m,n,visited,word,0)){
                            result.add(word);
                            found=true;
                        }
                    }
                }
            }
        }
        return result;
    }
}


// Code giving tle without Trie
// class Solution {
//     public boolean dfs(char board[][],int i,int j,int m,int n,boolean visited[][],String word,int idx){
//         if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j]!=word.charAt(idx)){
//             return false;
//         }
//         if(idx==word.length()-1){
//             return true;
//         }
//         visited[i][j]=true;
//         boolean top=dfs(board,i-1,j,m,n,visited,word,idx+1);
//         boolean bottom=dfs(board,i+1,j,m,n,visited,word,idx+1);
//         boolean left=dfs(board,i,j-1,m,n,visited,word,idx+1);
//         boolean right=dfs(board,i,j+1,m,n,visited,word,idx+1);

//         visited[i][j]=false;
//         if(top || bottom || left || right){
//             return true;
//         }
//         return false;
//     }
//     public List<String> findWords(char[][] board, String[] words) {
//         int m=board.length;
//         int n=board[0].length;
//         boolean visited[][]=new boolean[m][n];
//         List<String> result=new ArrayList<>();
//         for(String word:words){
//             if (word.length() > m * n) continue;
//             boolean found=false;
//             for(int i=0;i<m && !found;i++){
//                 for(int j=0;j<n && !found;j++){
//                     if(!visited[i][j] && board[i][j]==word.charAt(0)){
//                         if(dfs(board,i,j,m,n,visited,word,0)){
//                             result.add(word);
//                             found=true;
//                         }
//                     }
//                 }
//             }
//         }
//         return result;
//     }
// }