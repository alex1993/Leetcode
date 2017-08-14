package hihocoder.offer;

import java.util.*;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Main2 {

    static class Directory {
        String name;
        Map<String, Directory> sub;

        public Directory(String name) {
            this.name = name;
            sub = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Set<Directory> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine().trim());
        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = scanner.nextLine().trim();
        }

        Directory dummy = new Directory("");

        int res = 0;
        for (String path : strings) {
            Directory root = dummy;
            String[] dirs = path.split("/");
            for (int i = 1, dirsLength = dirs.length; i < dirsLength - 1; i++) {
                String dir = dirs[i];
                if (!root.sub.containsKey(dir)) {
                    root.sub.put(dir, new Directory(dir));
                    res++;
                }
                root = root.sub.get(dir);
            }
        }
        System.out.println(res);
    }
}
