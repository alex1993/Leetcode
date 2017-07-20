package solution500_599.solution599;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> rest1Map = new HashMap<>();
        Map<String, Integer> rest2Map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            rest1Map.putIfAbsent(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            rest2Map.putIfAbsent(list2[i], i);
        }

        List<String> res = new ArrayList<>();
        int minIndexSum = rest1Map.size() - 1 + rest2Map.size() - 1;
        for (Map.Entry<String, Integer> rest1 : rest1Map.entrySet()) {
            if (rest2Map.containsKey(rest1.getKey())) {
                int sum = rest1.getValue() + rest2Map.get(rest1.getKey());
                if (sum < minIndexSum) {
                    res.clear();
                    res.add(rest1.getKey());
                    minIndexSum = sum;
                } else if (sum == minIndexSum) {
                    res.add(rest1.getKey());
                }
            }
        }
        String[] strings = new String[res.size()];
        return res.toArray(strings);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] restaurant = solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"});
        System.out.println(Arrays.toString(restaurant));
    }

}
