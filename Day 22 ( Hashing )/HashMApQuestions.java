package hashing;

import java.util.*;

public class HashMApQuestions {
    // majority elements
    public static void majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if (hm.containsKey(nums[i])) {
            // hm.put(nums[i], hm.get(nums[i]) + 1);
            // } else {
            // hm.put(nums[i], 1);
            // }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(hm);
        Set<Integer> keys = hm.keySet();
        for (Integer key : keys) {
            if (hm.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (hm.get(ch) != null) {
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return hm.isEmpty();
    }

    public static void iteracyforTickets(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        String stpt = "";
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                stpt = key;
            }
        }
        System.out.print(stpt);
        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(stpt));
            stpt = tickets.get(stpt);
        }
        System.out.println();

    }

    public static int largestSubArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        return len;
    }

    public static int subArraySubK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0, sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 1, 3, 1, 5, 1 };
        majorityElement(nums);
        System.out.println(isAnagram("race", "care"));
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "bangluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");
        iteracyforTickets(tickets);
        int arr[] = { 15, -2, 2, 8, -1, -7, 10 };
        System.out.println("largest subarray with sum 0 is " + largestSubArray(arr));
        System.out.println(subArraySubK(arr, 0));
    }
}
