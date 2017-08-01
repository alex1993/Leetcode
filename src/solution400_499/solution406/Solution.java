package solution400_499.solution406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/28.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //先按照身高进行降序，然后根据前边的人数进行穿插，因为身高最高，所以只能看见和自己相同高度的人，所以顺序也是相对的
        Arrays.sort(people, (per1, per2) -> per1[0] != per2[0] ? per2[0] - per1[0] : per1[1] - per2[1]);
        //对于次高的人也是一样，直接按照他们前边的人的index进行插入就可以了
        int[][] ret = new int[people.length][2];
        List<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(ret);
    }

    //fixme: LTE Error
    public int[][] solve(int[][] people) {
        int[][] res = new int[people.length][2];
        Arrays.sort(people, (p1, p2) -> p1[1] != p2[1] ? p1[1] - p2[1] : p1[0] - p2[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            int height = person[0];
            int prevNum = person[1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] == prevNum) {
                list.addLast(person);
            } else {
                int i = 0;
                int listIndex = 0;
                while (i < prevNum) {
                    if (list.get(listIndex)[0] >= height) {
                        i++;
                    }
                    listIndex++;
                }
                while (listIndex < list.size() && list.get(listIndex)[1] == prevNum) {
                    listIndex++;
                }
                list.add(listIndex, person);
            }
        }
        return list.toArray(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.reconstructQueue(new int[][]{
            {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        })));
    }
}
