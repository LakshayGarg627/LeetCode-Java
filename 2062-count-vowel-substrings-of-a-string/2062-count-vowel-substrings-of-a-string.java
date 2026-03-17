class Solution {
    public int countVowelSubstrings(String word) {
        int n=word.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        int left=0;
        for(int right=0;right<n;right++){
            char ch=word.charAt(right);
            if(!(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')){
                map.clear();
                left=right+1;
                continue;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            int tempLeft = left;
            HashMap<Character,Integer> tempMap = new HashMap<>(map);
            while(tempMap.size()==5){
                count++;
                char toRem=word.charAt(tempLeft);
                tempMap.put(toRem,tempMap.getOrDefault(toRem,0)-1);
                if(tempMap.get(toRem)==0){
                    tempMap.remove(toRem);
                }
                tempLeft++;
            }
        }
        return count;
    }
}