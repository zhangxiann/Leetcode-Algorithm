import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n < 1)
            return res;
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> integers, int k, int start, int n) {
        if (k == 0) {
            if (n == 0)
                res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i <= 9 - k + 1; i++) {
            if (i <= n) {
                integers.add(i);
                backtrack(res, integers, k - 1, i + 1, n - i);
                integers.remove(integers.size() - 1);
            }
        }
    }
}
