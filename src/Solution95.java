import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> res = new LinkedList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTrees = generateTrees(l, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, r);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
