import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        visited = new boolean[nums.length];

        backtrack(res, new ArrayList<Integer>(), nums);

        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> integers, int[] nums) {
        if (integers.size() == nums.length) {
            res.add(new ArrayList<>(integers));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited[j])
                continue;
            integers.add(nums[j]);
            visited[j] = true;
            backtrack(res, integers, nums);
            integers.remove(integers.size()-1);
            visited[j] = false;
        }
    }
}
