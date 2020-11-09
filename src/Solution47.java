import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    private boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> integers) {
        if (integers.size() == nums.length) {
            res.add(new ArrayList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && visit[i - 1])
                continue;
            if (visit[i])
                continue;

            visit[i] = true;
            integers.add(nums[i]);
            backtrack(nums, res, integers);
            integers.remove(integers.size() - 1);
            visit[i] = false;
        }
    }
}
