public class LongestSubstringWithoutRepeatingCharacters3 {
    public static int lengthOfLongestSubstring(String s) {
        int left=0,right=0,len=s.length(),resLen=0;
        int[] hash = new int[128];
        while(right<len){
            if(left<right && hash[s.charAt(right)]==1){
                hash[s.charAt(left)] = 0;
                left++;
            }else{
                hash[s.charAt(right)] = 1;
                right++;
                resLen = Math.max(resLen,(right-left));
            }
        }
        return resLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
