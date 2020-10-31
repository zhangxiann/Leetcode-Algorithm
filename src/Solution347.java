// Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bukets = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bukets[freq] == null)
                bukets[freq] = new ArrayList<>();
            bukets[freq].add(key);
        }

        int[] topK = new int[k];
        int size = 0;
        for (int i = nums.length; i >= 0 && k >= size; i--) {
            if (bukets[i] == null) continue;
            if (bukets[i].size() <= (k - size)) {
                //topK.addAll(bukets[i]);
                for (int j = 0; j < bukets[i].size(); j++) {
                    topK[size++] = bukets[i].get(j);
                }
            } else
                for (int j = 0; j < k - size; j++) {
                    topK[size++] = bukets[i].get(j);
                }
            //topK.addAll(bukets[i].subList(0,k-topK.size()));
        }
        return topK;
    }
}
