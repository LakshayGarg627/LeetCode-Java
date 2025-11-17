class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        StringBuilder sb=new StringBuilder("");
        boolean negative=false;
        int i=0;
        if (s.length() > 1 && s.charAt(0) == '-' && s.charAt(1) == '0') {
            negative = true;
            i = 2;
        }
        else if(s.charAt(0)=='-' ){
            negative=true;
            i=1;
        }else if(s.charAt(0)=='+'){
            i=1;
        }

        for(int j=i;j<s.length();j++){
            char ch=s.charAt(j);
            if(ch>='0' && ch<='9'){
                sb.append(ch);
            }else{
                break;
            }
        }
        if(sb.length()==0){
            return 0;
        }
        long num = 0;
        for (int k = 0; k < sb.length(); k++) {
            int digit = sb.charAt(k) - '0';

            if (num > Integer.MAX_VALUE / 10 ||
               (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
        }
        if(negative){
            num=-num;
        }
        if(num>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(num<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)num;
    }
}