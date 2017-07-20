package solution600_699.solution638;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/9.
 */
public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            boolean over = minusNeeds(needs, offer);
            if (!over) {
                result = Math.min(result, shoppingOffers(price, special, needs) + offer.get(needs.size()));
            }
            upNeeds(needs, offer);
        }
        int nonOfferPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
            nonOfferPrice += price.get(i) * needs.get(i);
        }
        return Math.min(result, nonOfferPrice);
    }

    private boolean minusNeeds(List<Integer> needs, List<Integer> special) {
        boolean over = false;
        for (int i = 0; i < needs.size(); i++) {
            int remain = needs.get(i) - special.get(i);
            needs.set(i, remain);
            if (remain < 0) {
                over = true;
            }
        }
        return over;
    }

    private void upNeeds(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) + special.get(i));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> specialList = new ArrayList<>();
        specialList.add(Arrays.asList(3, 0, 5));
        specialList.add(Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println(solution.shoppingOffers(price, specialList, needs));
    }

}