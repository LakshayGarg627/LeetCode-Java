class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        List<Integer> result=new ArrayList<>();
        int n=s.length();
        int temp[]=new int[26];
        int temp1[]=new int[26];
        for(int i=0;i<p.length();i++){
            temp1[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            temp[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(temp,temp1)){
            result.add(0);
        }
        for(int i=1;i<=n-p.length();i++){
            char ch1=s.charAt(i-1);
            char ch2=s.charAt(i+p.length()-1);

            temp[ch1-'a']--;
            temp[ch2-'a']++;

            if(Arrays.equals(temp1,temp)){
                result.add(i);
            }

        }
        return result;
    }
}

// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         if(p.length() > s.length()) return new ArrayList<>();
//         List<Integer> result=new ArrayList<>();
//         int freq[]=new int[26];
//         for(int i=0;i<p.length();i++){
//             freq[p.charAt(i)-'a']++;
//         }
        
//         int temp[]=new int[26];
        
//         for(int i=0;i<p.length();i++){
//             temp[s.charAt(i)-'a']++;
//         }
//         if(Arrays.equals(temp,freq)){
//             result.add(0);
//         }
//         for(int i=1;i<s.length()-p.length()+1;i++){
//             char ch1=s.charAt(i-1);
//             char ch2=s.charAt(i+p.length()-1);

//             temp[ch1-'a']--;
//             temp[ch2-'a']++;

//             if(Arrays.equals(temp,freq)){
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }

// More optimised approach using sliding window
// class Solution {
//     public boolean anagram(String s1,String s2){
//         if (s1.length() != s2.length()) return false;

//         int[] freq = new int[26];
//         for (int i = 0; i < s1.length(); i++){
//             freq[s1.charAt(i) - 'a']++;
//             freq[s2.charAt(i) - 'a']--;
//         }

//         for (int f : freq) {
//             if (f != 0) return false;
//         }

//         return true;
//     }
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> result=new ArrayList<>();
//         int m=p.length();
//         for(int i=0;i<=s.length()-m;i++){
//             String substr=s.substring(i,i+m);
            
//             if(anagram(substr,p)){
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }
