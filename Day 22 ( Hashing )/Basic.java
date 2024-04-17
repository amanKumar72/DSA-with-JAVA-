package hashing;

import java.util.*;

public class Basic {

    public static void main(String[] args) {
        // hash Map unorderes TC = O(1)
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 41);
        hm.put("china", 45);
        hm.put("US", 25);
        hm.put("Nepal", 15);
        System.out.println(hm);
        System.out.println(hm.get("china"));
        System.out.println(hm);
        hm.containsKey("India");
        System.out.println(hm.remove("Nepal"));
        System.err.println(hm.isEmpty());
        System.out.println(hm.size());
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.print(" Key = " + k + " Value = " + hm.get(k));
        }
        System.err.println();
        hm.clear();
        System.out.println(hm.isEmpty());

        // Linked hash Map order TC = O(1)
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 41);
        lhm.put("china", 45);
        lhm.put("US", 25);
        lhm.put("Nepal", 15);
        System.out.println(lhm);

        // tree Map o(log n ) in asc order
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 41);
        tm.put("China", 45);
        tm.put("US", 25);
        tm.put("Nepal", 15);
        System.out.println(tm);

        System.err.println();
        System.err.println();
        System.err.println();

        // hash set unorderes TC = O(1)
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(3);
        hs.add(2);
        hs.add(4);
        hs.add(1);
        System.out.println(hs);
        System.out.println(hs.remove(2));
        System.out.println(hs.contains(2));
        System.out.println(hs.size());
        System.out.println();

        // Linked hash set order TC = O(1)
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(3);
        lhs.add(2);
        lhs.add(4);
        lhs.add(1);
        System.out.println(lhs);
        System.out.println(lhs.remove(2));
        System.out.println(lhs.contains(2));
        System.out.println(lhs.size());
        System.out.println();

        // tree set o(log n ) in asc order
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(3);
        ts.add(2);
        ts.add(4);
        ts.add(1);
        System.out.println(ts);
        System.out.println(ts.remove(2));
        System.out.println(ts.contains(2));
        System.out.println(ts.size());
        System.out.println();
    }
}