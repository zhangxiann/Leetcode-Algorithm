// Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/description/

public class Solution680 {
    public boolean validPalindrome(String s) {
        if (s==null || s.length()==0)
            return false;
        int left=0, right=s.length()-1;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
