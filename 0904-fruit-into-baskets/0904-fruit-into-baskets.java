class Solution {
    public int totalFruit(int[] fruits) {
       int n=fruits.length;
       if(n==1 || n==2){
        return n;
       }
       HashMap<Integer,Integer> map=new HashMap<>();
       
       int left=0;
       int maxFruit=0;
       for(int right=0;right<n;right++){
            int currele=fruits[right];
            map.put(currele,map.getOrDefault(currele,0)+1);
            while(map.size()>2){
                int toremove=fruits[left];
                map.put(toremove,map.getOrDefault(toremove,0)-1);
                if(map.get(toremove)==0){
                    map.remove(toremove);
                }
                left++;
            }
            if(map.size()<=2){
                maxFruit=Math.max(maxFruit,right-left+1);
            }
            
       } 
       return maxFruit;
    }
}