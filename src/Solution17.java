import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        getCombination(res, digits, new StringBuilder());
        return res;
    }

    private void getCombination(List<String> res, String digits, StringBuilder prefix) {
        if (prefix.length() == digits.length()) {
            res.add(prefix.toString());
            return;
        }
        int curDigit = digits.charAt(prefix.length()) - '0';
        for (char c : KEYS[curDigit].toCharArray()) {
            prefix.append(c);
            getCombination(res, digits, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
