class Solution {
    public String sort(String s){
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=sort(strs[i]);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        List<List<String>> result=new ArrayList<>();
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}

// class Solution {
//     class Node{
//         Node[] children=new Node[26];
//         boolean eow=false;
//         List<String> anaList;
//         Node(){
//             for(int i=0;i<children.length;i++){
//                children[i]=null;
//             }
//             anaList=new ArrayList<>();
//         }

//     }
//     public Node root=new Node();
//     public void insert(String str){
//         Node curr=root;
//         char[] word=str.toCharArray();
//         Arrays.sort(word);
//         for(int i=0;i<word.length;i++){
//             int idx=word[i]-'a';
//             if(curr.children[idx]==null){
//                 curr.children[idx]=new Node();
//             }
//             curr=curr.children[idx];
//         }
//         curr.eow=true;
//         curr.anaList.add(str);
//     }
//     public void populate(Node root,List<List<String>> ans){
//         if(root.eow==true){
//             ans.add(root.anaList);
//         }

//         for(int i=0;i<26;i++){
//             if(root.children[i]!=null){
//                 populate(root.children[i],ans);
//             }
//         }
//     }
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans=new ArrayList<>();

//         for(int i=0;i<strs.length;i++){
//             insert(strs[i]);
//         }

//         populate(root,ans);
//         return ans;
//     }
// }