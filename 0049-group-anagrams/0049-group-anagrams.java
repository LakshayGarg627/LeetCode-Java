class Solution {
    public String sort(String str){
        char ch[]=str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        int n=strs.length;
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String str=strs[i];
            String sorted_String=sort(str);
            if(!map.containsKey(sorted_String)){
                map.put(sorted_String,new ArrayList<>());
            }
            map.get(sorted_String).add(str);
        }
        System.out.println(map);
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}