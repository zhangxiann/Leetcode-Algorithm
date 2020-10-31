// Sort Characters By Frequency
// https://leetcode.com/problems/sort-characters-by-frequency/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            if (buckets[i] == null)
                continue;
            for (char c : buckets[i])
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
        }
        return sb.toString();
    }
}
