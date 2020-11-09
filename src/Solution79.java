public class Solution79 {
    private int m, n;
    private boolean[][] visited;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;
        for (int[] d : directions) {
            if (backtrack(board, word, index + 1, i + d[0], j + d[1]))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}
