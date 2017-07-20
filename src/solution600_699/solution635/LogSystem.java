package solution600_699.solution635;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Script Created by daidai on 2017/7/2.
 */
public class LogSystem {

    private TreeMap<String, Integer> treeMap;

    public LogSystem() {
        treeMap = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        treeMap.put(timestamp, id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        s = granularity(gra, s, true);
        e = granularity(gra, e, false);
        System.out.println(treeMap);
        SortedMap<String, Integer> greater = treeMap.subMap(s, true, e, true);
        return new ArrayList<>(greater.values());
    }

    private String granularity(String gra, String time, boolean start) {
        int target = 0;
        if (gra.equals("Year")) {
            target = 0;
        }
        if (gra.equals("Month")) {
            target = 1;
        }
        if (gra.equals("Day")) {
            target = 2;
        }
        if (gra.equals("Hour")) {
            target = 3;
        }
        if (gra.equals("Minute")) {
            target = 4;
        }
        if (gra.equals("Second")) {
            target = 5;
        }
        String[] strings = time.split(":");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (i <= target) {
                list.add(strings[i]);
            } else {
                if (start) {
                    list.add("00");
                } else {
                    list.add("59");
                }
            }
        }
        return String.join(":", list);
    }

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");
        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        System.out.println(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
