import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
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
            integers.add(nums[i]);
            backtrack(res, integers, nums, i + 1, size);
            integers.remove(integers.size() - 1);
        }
    }
}
