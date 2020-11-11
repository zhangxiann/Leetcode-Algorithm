import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutin40 {
    private boolean[] visit;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        visit = new boolean[candidates.length];
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> integers, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i!=0 && candidates[i]==candidates[i-1] && visit[i-1])
                continue;

            if (candidates[i] <= target) {
                integers.add(candidates[i]);
                visit[i]=true;
                backtrack(res, integers, candidates, target - candidates[i], i + 1);
                integers.remove(integers.size() - 1);
                visit[i]=false;
            }
        }
    }
}
