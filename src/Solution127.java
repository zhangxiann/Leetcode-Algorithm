import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        while (end < n && !wordList.get(end).equals(endWord))

            end++;
        if (end == n)
            return 0;
        List<Integer>[] graph = generateGraph(wordList);
        return getShortestPath(graph, n, start, end);
    }

    private int getShortestPath(List<Integer>[] graph, int n, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        int path = 1;
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size > 0) {
                size--;
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (next==end)
                        return path;
                    if (marked[next])
                        continue;
                    marked[next]=true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<Integer>[] generateGraph(List<String> wordList) {
        List<Integer>[] graph = new List[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                }
            }
        }
        return graph;
    }

    private boolean isConnected(String s1, String s2) {
        int diff = 0;
        int i = 0;
        while (i < s1.length() && diff <= 1) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
            i++;
        }
        return diff == 1;
    }
}
