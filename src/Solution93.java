import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        getIPs(res, 0, s, new StringBuilder());
        return res;
    }

    private void getIPs(List<String> res, int index, String s, StringBuilder sb) {
        if (index == 4 || s.length() == 0) {
            if (index == 4 && s.length() == 0) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0')
                continue;
            String part = s.substring(0, i + 1);
            if (Integer.parseInt(part) <= 255) {
                if (index != 0) {
                    part = '.' + part;
                }
                sb.append(part);
                getIPs(res, index + 1, s.substring(i + 1), sb);
                sb.delete(sb.length() - part.length(), sb.length());
            }
        }
    }
}
