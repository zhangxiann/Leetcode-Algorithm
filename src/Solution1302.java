import java.util.LinkedList;
import java.util.Queue;

public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root==null)
            return 0;
        int sum=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            sum=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
        }
        return sum;
    }
}
