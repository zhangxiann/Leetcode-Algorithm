// Longest Word in Dictionary through Deleting
// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/

import java.util.List;

public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String tmp : d) {
            int l1=longestWord.length();
            int l2=tmp.length();
            if (l1>l2  || (l1==l2 && longestWord.compareTo(tmp)<0))
                continue;
            if (isSubStr(s,tmp))
                longestWord=tmp;
        }
        return longestWord;
    }

    private boolean isSubStr(String s, String tmp) {
        int i=0, j=0;
        while (i<s.length() && j<tmp.length()){
            if (s.charAt(i)==tmp.charAt(j))
                j++;
            i++;
        }
        return j==tmp.length();
    }
}
