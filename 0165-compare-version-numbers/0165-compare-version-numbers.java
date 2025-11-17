class Solution {
    public int compareVersion(String version1, String version2) {
        String temp1[]=version1.trim().split("\\.");
        List<Integer> list1=new ArrayList<>();
        for(int i=0;i<temp1.length;i++){
            list1.add(Integer.parseInt(temp1[i]));
        }
        String temp2[]=version2.trim().split("\\.");
        List<Integer> list2=new ArrayList<>();
        for(int i=0;i<temp2.length;i++){
            list2.add(Integer.parseInt(temp2[i]));
        }
        int len=Math.max(list1.size(),list2.size());
        for(int i=0;i<len;i++){
            int a=i<list1.size()?list1.get(i):0;
            int b=i<list2.size()?list2.get(i):0;
            if(a<b){
                return -1;
            }
            if(a>b){
                return 1;
            }
        }
        return 0;
    }
}