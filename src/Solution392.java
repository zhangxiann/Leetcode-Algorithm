public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0)
            return true;
        int si=0,ti=0;
        for (; ti < t.length(); ti++) {
            if (s.charAt(si)==t.charAt(ti)){
                si++;
                if(si==s.length())
                    return true;
            }
        }
        return false;
    }
}
