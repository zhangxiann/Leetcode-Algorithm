import java.util.*;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[] p: people){
            list.add(p[1],p);
        }
        int n = people.length;
        return list.toArray(new int[n][2]);
    }
}
