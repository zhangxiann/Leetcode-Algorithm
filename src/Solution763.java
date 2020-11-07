import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        Arrays.fill(map,-1);
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i)-'a']=i;
        }
        int start =0;
        List<Integer> res = new ArrayList<>();
        while (start<S.length()){
            int end = map[S.charAt(start)-'a'];
            for (int i = start; i <= end; i++) {
                end = Math.max(end, map[S.charAt(i)-'a']);
            }
            res.add(end-start+1);
            start=end+1;
        }
        return res;
    }
}
