import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1091 {
/*    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0)
            return -1;
        int[][] direction = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}
                ,{0,1},{0,-1},{-1,0},{1,0}};
        int length=0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int m = grid.length, n=grid[0].length;

        while (!queue.isEmpty()){
            int size = queue.size();
            length++;
            while (size>0){
                size--;
                Pair<Integer, Integer> cur = queue.poll();
                int cr=cur.getKey(), cc=cur.getValue();
                if(grid[cr][cc]==1)
                    continue;

                if (cr==m-1 && cc==n-1)
                    return length;

                grid[cr][cc]=1;

                for (int[] d: direction) {
                    int nr=cr+d[0], nc=cc+d[1];
                    if (nr<0 || nr>=m || nc<0 || nc>=n)
                        continue;
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }*/


    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length==0 || grid[0].length==0)
            return -1;
        int length=0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int[][] direction=new int[][]{{0,1},{0,-1},{-1,0},{1,0}
                ,{1,1},{1,-1},{-1,1},{-1,-1}};

        int m=grid.length,n=grid[0].length;
        while (!queue.isEmpty()){
            int size= queue.size();
            length++;
            while (size>0){
                size--;
                Pair<Integer,Integer> cur = queue.poll();
                int nr = cur.getKey(),nc=cur.getValue();
                if (grid[nr][nc]==1)
                    continue;
                if (nr==m-1 && nc==n-1)
                    return length;
                grid[nr][nc]=1;
                for(int[] d : direction){
                    int r=nr+d[0], c=nc+d[1];
                    if (r<0 || r>=m || c<0 || c>=n)
                        continue;
                    queue.add(new Pair<>(r,c));
                }
            }
        }
        return -1;
    }


}
