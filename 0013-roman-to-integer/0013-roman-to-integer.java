class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n=s.length();
        int result=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i+1<n){
                if(ch=='I' && s.charAt(i+1)=='V'){
                    result+=4;
                    i++;
                    continue;
                }
                else if(ch=='I' && s.charAt(i+1)=='X'){
                    result+=9;
                    i++;
                    continue;
                }
                else if(ch=='X' && s.charAt(i+1)=='L'){
                    result+=40;
                    i++;
                    continue;
                }
                else if(ch=='X' && s.charAt(i+1)=='C'){
                    result+=90;
                    i++;
                    continue;
                }
                else if(ch=='C' && s.charAt(i+1)=='D'){
                    result+=400;
                    i++;
                    continue;
                }else if(ch=='C' && s.charAt(i+1)=='M'){
                    result+=900;
                    i++;
                    continue;
                }
            }

            result+=(map.get(ch));
            
        }
        
        return result;
    }
}