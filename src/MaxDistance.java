public class MaxDistance {
    public int maxDist(int num[]) {
        if (num == null || num.length < 2)
            return 0;
        int n = num.length;
        int[] leftMinPos = new int[n];
        int curMinPos = 0;
        for (int i = 1; i < n; i++) {
            if (num[i] < num[curMinPos]) {
                curMinPos = i;
                leftMinPos[i] = i;
            } else {
                leftMinPos[i] = curMinPos;
            }
        }

        int right = n - 1;
        int maxDistance = 0;
        int left = leftMinPos[n - 1];
        while (left >= 0) {
            left = leftMinPos[left];
            if (num[right] > num[left]) {
                if (right - left > maxDistance)
                    maxDistance = right - left;
                left--;
            } else {
                right--;
            }
        }
        return maxDistance;
    }
}
