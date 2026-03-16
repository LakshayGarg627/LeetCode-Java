class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int maxcount=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxcount=Math.max(maxcount,right-left+1);
        }
        return maxcount;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n=s.length();
//         HashSet<Character> set=new HashSet<>();
//         int left=0;
//         int maxCount=0;
//         for(int right=0;right<n;right++){
//             char ch=s.charAt(right);
//             while(set.contains(ch)){
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//             set.add(ch);
//             maxCount=Math.max(maxCount,right-left+1);
//         }
//         return maxCount;
//     }
// }

