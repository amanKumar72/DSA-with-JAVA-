import java.util.ArrayList;

public class TriesQuestions {
  // prefix problem
  public static class Node {
    Node[] children = new Node[26];
    boolean eow = false;
    int freq;

    public Node() {
      for (int i = 0; i < 26; i++) {
        children[i] = null;
      }
      freq = 1;
    }
  }

  public static Node root = new Node();

  public static void insert(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int indx = word.charAt(i) - 'a';
      if (curr.children[indx] == null) {
        curr.children[indx] = new Node();
      } else {
        curr.children[indx].freq++;
      }
      curr = curr.children[indx];
    }
  }

  public static ArrayList<String> prefixArrray(String[] words) {
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      Node curr = root;
      for (int j = 0; j < word.length(); j++) {
        int indx = word.charAt(j) - 'a';
        if (curr.children[indx].freq == 1) {
          result.add(word.substring(0, j + 1));
          break;
        } else {
          curr = curr.children[indx];
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String words[] = { "zebra", "dog", "dove", "duck" };
    for (int i = 0; i < words.length; i++) {
      insert(words[i]);
    }
    System.out.println(prefixArrray(words));
  }

}
