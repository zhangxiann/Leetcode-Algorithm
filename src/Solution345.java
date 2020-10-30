// Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/description/


import java.util.Arrays;
import java.util.HashSet;

public class Solution345 {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
            }
            left++;
            right--;
        }
        return new String(chars);
    }
}
