import java.util.*;

public class FirstNonRepeatingCharacter {
  public static void nonRepeating(String str) {
    Queue<Character> q = new ArrayDeque<>();
    int freq[] = new int[26];
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      q.add(ch);
      freq[ch - 'a']++;
      while (!q.isEmpty() && (freq[q.peek() - 'a'] > 1)) {
        q.remove();
      }
      if (q.isEmpty()) {
        System.out.println("-1");
      } else {
        System.out.println(q.peek());
      }
    }
  }

  public static void main(String[] args) {
    String str = "aabccxb";
    nonRepeating(str);

  }
}
