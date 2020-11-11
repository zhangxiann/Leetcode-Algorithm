import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    private boolean[] visit;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++) {
            backtrack(res, new ArrayList<Integer>(), nums, 0, size);
        }
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> integers, int[] nums, int start, int size) {
        if (integers.size() == size) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && visit[i-1])
                continue;
            integers.add(nums[i]);
            visit[i] = true;
            backtrack(res, integers, nums, i + 1, size);
            visit[i] = false;
            integers.remove(integers.size() - 1);
        }
    }
}
