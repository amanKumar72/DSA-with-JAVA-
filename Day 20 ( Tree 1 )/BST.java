import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class BST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  // BST TO BALANCED BST
  public static void inorder(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      return;
    }
    inorder(root.left, arr);
    arr.add(root.data);
    inorder(root.right, arr);
  }

  public static Node balancedBST(ArrayList<Integer> arr, int st, int end) {
    if (st > end) {
      return null;
    }
    int mid = (st + end) / 2;
    Node root = new Node(arr.get(mid));
    root.left = balancedBST(arr, st, mid - 1);
    root.right = balancedBST(arr, mid + 1, end);
    return root;
  }

  public static Node BSTToBalancedBST(Node root) {
    ArrayList<Integer> arr = new ArrayList<>();
    // inorder sort
    inorder(root, arr);
    // construct balanced bst from sorted array
    root = balancedBST(arr, 0, arr.size() - 1);
    return root;
  }

  // largest BST
  public static class Info2 {
    boolean isBST;
    int size, max, min;

    public Info2(boolean isBST, int size, int max, int min) {
      this.isBST = isBST;
      this.size = size;
      this.max = max;
      this.min = min;
    }
  }

  public static int maxMST = 0;

  public static Info2 largestBST(Node root) {
    if (root == null) {
      return new Info2(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    Info2 linfo = largestBST(root.left);
    Info2 rinfo = largestBST(root.right);
    int size = linfo.size + rinfo.size + 1;
    int max = Math.max(Math.max(linfo.max, rinfo.max), root.data);
    int min = Math.min(Math.min(linfo.min, rinfo.min), root.data);
    if (linfo.max >= root.data || rinfo.min <= root.data) {
      return new Info2(false, size, max, min);
    }
    if (linfo.isBST && rinfo.isBST) {
      maxMST = Math.max(size, maxMST);
      return new Info2(true, size, max, min);
    }
    return new Info2(false, size, max, min);
  }

  // Merge BSTs
  public static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
    int i = 0, j = 0;
    ArrayList<Integer> merg = new ArrayList<>();
    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) < arr2.get(j)) {
        merg.add(arr1.get(i++));
      } else {
        merg.add(arr2.get(j++));
      }
    }
    while (i < arr1.size()) {
      merg.add(arr1.get(i++));
    }
    while (j < arr2.size()) {
      merg.add(arr2.get(j++));
    }
    return merg;
  }

  public static Node mergeBSTs(Node root1, Node root2) {
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> merg = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    inorder(root1, arr1);
    inorder(root2, arr2);
    merg = merge(arr1, arr2);

    return balancedBST(merg, 0, merg.size() - 1);
  }

  // create,search,delete and print BST

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }
    if (root.data > val) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }

  public static boolean search(Node root, int key) {
    if (root == null) {
      return false;
    }
    if (root.data == key) {
      return true;
    }
    if (root.data > key) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }

  public static Node delete(Node root, int key) {
    if (root.data > key) {
      root.left = delete(root.left, key);
    } else if (root.data < key) {
      root.right = delete(root.right, key);
    } else {
      // case 1 leaf node
      if (root.left == null && root.right == null) {
        return null;
      }
      // case 2 have one child
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
      // case 3 have 2 child
      Node IS = findIS(root.right);
      root.data = IS.data;
      root.right = delete(root.right, IS.data);
    }
    return root;
  }

  public static Node findIS(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public static void printInorder(Node root) {
    if (root == null) {
      return;
    }
    printInorder(root.left);
    System.out.print(root.data + " ");
    printInorder(root.right);
  }

  public static void printInRange(Node root, int k1, int k2) {
    if (root == null) {
      return;
    }
    if (root.data >= k1 && root.data <= k2) {
      printInRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printInRange(root.right, k1, k2);
    } else if (root.data < k1) {
      printInRange(root.left, k1, k2);
    } else {
      printInRange(root.right, k1, k2);
    }
  }

  public static void printRootToNode(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.left == null && root.right == null) {
      System.out.println(path);
    }
    printRootToNode(root.left, path);
    printRootToNode(root.right, path);
    path.remove(path.size() - 1);

  }

  public static boolean isValidBST(Node root, Node min, Node max) {
    if (root == null) {
      return true;
    }
    if (max != null && root.data >= max.data) {
      return false;
    } else if (min != null && root.data <= min.data) {
      return false;
    }
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

  public static Node mirrorBST(Node root) {
    if (root == null) {
      return null;
    }
    Node lefts = mirrorBST(root.left);
    Node rights = mirrorBST(root.right);
    root.left = rights;
    root.right = lefts;
    return root;
  }

  public static void main(String[] args) {
    int nodes1[] = { 2, 1, 3 };
    Node root1 = null;
    for (int i = 0; i < nodes1.length; i++) {
      root1 = insert(root1, nodes1[i]);
    }
    int nodes2[] = { 9, 4, 12 };
    Node root2 = null;
    for (int i = 0; i < nodes2.length; i++) {
      root2 = insert(root2, nodes2[i]);
    }

    Node root = mergeBSTs(root1, root2);
    // root=BSTToBalancedBST(root);
    printInorder(root);
    System.out.println();
    preorder(root);
    // root=mirrorBST(root);
    // printInorder(root);
    // System.out.println();
    // preorder(root);
    // System.out.println(search(root, 3));
    // System.out.println(search(root, 65));
    // root=delete(root, 3);
    // System.out.println(root.data);
    // printInorder(root);
    // printInRange(root, 1, 7);
    // System.out.println(maxMST);
    // System.out.println(isValidBST(root, null, null));
    printRootToNode(root, new ArrayList<>());
  }
}
