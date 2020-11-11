import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> integers, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                integers.add(candidates[i]);
                backtrack(res, integers, candidates, target - candidates[i], i);
                integers.remove(integers.size() - 1);
            }
        }
    }
}

