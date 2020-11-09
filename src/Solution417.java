import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution417 {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return res;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, matrix, canReachP);
            dfs(i, n - 1, matrix, canReachA);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, matrix, canReachP);
            dfs(m - 1, i, matrix, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] matrix, boolean[][] canReach) {
        if (canReach[i][j])
            return;
        canReach[i][j] = true;
        for (int[] d : directions) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n ||
                    matrix[i][j] > matrix[ni][nj])
                continue;
            dfs(ni, nj, matrix, canReach);
        }
    }
}
