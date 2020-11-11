import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1)
            return res;
        backtrack(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }


    private void backtrack(List<List<Integer>> res, ArrayList<Integer> integers, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i <= n-k+1; i++) {
            integers.add(i);
            backtrack(res, integers, i + 1, n, k-1);
            integers.remove(integers.size() - 1);
        }
    }
}
