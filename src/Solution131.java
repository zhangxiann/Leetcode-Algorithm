import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        backtrack(s, res, new ArrayList<String>());
        return res;
    }

    private void backtrack(String s, List<List<String>> res, ArrayList<String> strings) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(strings));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i+1))) {
                strings.add(s.substring(0, i+1));
                backtrack(s.substring(i+1), res, strings);
                strings.remove(strings.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring) {
        int begin = 0, end = substring.length() - 1;
        while (begin < end) {
            if (substring.charAt(begin) != substring.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        List<List<String>> res = solution131.partition("aab");
        for (List<String> strings : res){
            for (String s: strings)
                System.out.print(s+" ");
            System.out.println();
        }
    }
}
