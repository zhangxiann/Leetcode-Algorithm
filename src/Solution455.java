// Assign Cookies
// https://leetcode.com/problems/assign-cookies/description/


import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g==null || s==null){
            return 0;
        }
        int cnt=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0,si=0;
        for ( ; si < s.length && gi < g.length; si++) {
            if (s[si]>=g[gi]){
                gi++;
                cnt++;
            }
        }
        return cnt;
    }
}

