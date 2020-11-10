public class Solution955 {
    public int minDeletionSize(String[] A) {
        int m = A[0].length();
        int n = A.length;
        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean isDelete = false;
            for (int j = 1; j < n; j++) {
                if (visit[j]) continue;
                if (A[j - 1].charAt(i) > A[j].charAt(i))
                    isDelete = true;
            }
            if (isDelete)
                count++;
            else {
                for (int j = 0; j < n; j++) {
                    if (A[j - 1].charAt(i) < A[j].charAt(i))
                        visit[j] = true;
                }
            }
        }
        return count;
    }
}
