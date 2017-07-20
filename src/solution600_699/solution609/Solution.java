package solution600_699.solution609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Script Created by daidai on 2017/6/4.
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> content2Path = new HashMap<>();
        for (String path : paths) {
            String[] strings = path.split(" ");
            //extract all content
            for (int i = 1; i < strings.length; i++) {
                String content = extractContent(strings[i]);
                content2Path.putIfAbsent(content, new ArrayList<>());
                content2Path.get(content).add(extractPath(strings[i], strings[0]));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : content2Path.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        return res;
    }

    private String extractPath(String fileName, String direct) {
        int end = fileName.indexOf('(');
        return direct + "/" + fileName.substring(0, end);
    }

    private String extractContent(String string) {
        int s = string.indexOf('(');
        int e = string.indexOf(')');
        return string.substring(s, e);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> duplicate = solution.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"});
        System.out.println(duplicate);
    }
}
