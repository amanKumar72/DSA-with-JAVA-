public class TriesBasic {
  public static class Node {
    Node[] children = new Node[26];
    boolean eow = false;

    public Node() {
      for (int i = 0; i < 26; i++) {
        children[i] = null;
      }
    }
  }

  public static Node root = new Node();

  public static void insert(String word) {
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int indx = word.charAt(level) - 'a';
      if (curr.children[indx] == null) {
        curr.children[indx] = new Node();
      }
      curr = curr.children[indx];

    }
    curr.eow = true;
  }

  public static boolean search(String word) {
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int indx = word.charAt(level) - 'a';
      if (curr.children[indx] == null) {
        return false;
      } else {
        curr = curr.children[indx];
      }
    }
    return curr.eow;
  }

  // Word break problem
  public static boolean wordBreak(String key) {
    if (key.length() == 0) {
      return true;
    }
    for (int i = 1; i <= key.length(); i++) {
      if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
        return true;
      }
    }
    return false;
  }

  // STARTSWITH THE GIVEN WORD
  public static boolean startswith(String prefix) {
    Node curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      int indx = prefix.charAt(i) - 'a';
      if (curr.children[indx] == null) {
        return false;
      }
      curr = curr.children[indx];
    }
    return true;
  }

  public static int countNodes(Node root) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (root.children[i] != null) {
        count += countNodes(root.children[i]);
      }
    }
    return count + 1;
  }

  static String ans = "";

  public static void longestWord(Node root, StringBuilder temp) {
    if (root == null) {
      return;
    }
    for (int i = 0; i < 26; i++) {
      if (root.children[i] != null && root.children[i].eow == true) {
        temp.append((char) (i + 'a'));
        if (temp.length() > ans.length()) {
          ans = temp.toString();
        }
        longestWord(root.children[i], temp);
        temp.deleteCharAt(temp.length() - 1);
      }
    }
  }

  public static void main(String[] args) {
    // String words[] = { "i", "love", "sam", "samsung", "great" };
    // for (int i = 0; i < words.length; i++) {
    // insert(words[i]);
    // }
    // System.out.println(search("i"));
    // System.out.println(search("sam"));
    // System.out.println(search("greatest"));
    // System.out.println(wordBreak("ilove"));
    // System.out.println(wordBreak("ilovesung"));
    // System.out.println(startswith("lov"));
    // System.out.println(startswith("lovely"));
    // System.out.println();
    // String str = "ababa";
    // for (int i = 0; i < str.length(); i++) {
    // insert(str.substring(i));
    // }
    String wordString[] = { "a", "apple", "app", "ap", "appl", "apply", "ba", "banana" };
    for (int i = 0; i < wordString.length; i++) {
      insert(wordString[i]);
    }
    longestWord(root, new StringBuilder(""));
    System.out.println(ans);
  }
}