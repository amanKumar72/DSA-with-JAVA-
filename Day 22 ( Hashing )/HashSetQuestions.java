package hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetQuestions {
    public static int distinctElements(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        return hs.size();
    }

    public static ArrayList<Integer> union(int arr1[], int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> uni = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        for (Integer i : hs) {
            uni.add(i);
        }
        return uni;
    }

    public static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> is = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                is.add(arr2[i]);
                hs.remove(arr2[i]);
            }
        }
        return is;
    }

    public static void print(ArrayList<Integer> arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " , ");
        }
        System.out.print(" ]");
        System.out.print(" Size = " + arr.size());
        System.err.println();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 5, 6, 7, 8 };
        System.out.println(distinctElements(nums));
        int[] arr1 = { 1, 3, 9 };
        int[] arr2 = { 3, 5, 9, 2, 9, 4 };
        print(union(arr1, arr2));
        print(intersection(arr1, arr2));

    }
}
