public class Solution547 {
    private int m;
    private boolean[] marked;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        m = M.length;
        marked = new boolean[m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!marked[i]) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i) {
        marked[i] = true;
        for (int j = 0; j < m; j++) {
            if (!marked[j] && M[i][j] == 1)
                dfs(M, j);
        }
    }
}
