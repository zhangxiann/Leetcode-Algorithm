import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        List<Integer> values = new ArrayList<>();
        backtrack(root, paths, values);
        return paths;
    }

    private void backtrack(TreeNode root, List<String> paths, List<Integer> values) {
        if (root == null) {
            return;
        }

        values.add(root.val);

        if (isLeaf(root)) {
            paths.add(buildPath(values));
        } else {
            backtrack(root.left, paths, values);
            backtrack(root.right, paths, values);
        }

        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if (i != values.size() - 1)
                sb.append("->");
        }
        return sb.toString();
    }


}
