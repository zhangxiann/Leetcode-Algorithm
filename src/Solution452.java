// Minimum Number of Arrows to Burst Balloons
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //Arrays.sort(points, Comparator.comparingInt(o->o[1]));
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 这里不能使用 o1[1] - o2[1]，要注意溢出问题
                if (a[1] < b[1])
                    return -1;
                else if (a[1] > b[1])
                    return 1;
                else return 0;
            }
        });
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }


/*    public int findMinArrowShots(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            // 把 >= 改成 > 就行了
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }*/
/*    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int end = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            if (start > end) {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }*/

    public static void main(String[] args) {
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        //int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int cnt = new Solution452().findMinArrowShots(points);
        System.out.println(cnt);

    }
}
