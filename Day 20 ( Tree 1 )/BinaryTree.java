import java.util.*;

public class BinaryTree {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  static class Tree {
    static int indx = -1;

    public static Node BuildTree(int[] nodes) {
      indx++;
      if (nodes[indx] == -1) {
        return null;
      }
      Node newNode = new Node(nodes[indx]);
      newNode.left = BuildTree(nodes);
      newNode.right = BuildTree(nodes);
      return newNode;
    }

    public static void preorder(Node root) {
      if (root == null) {
        return;
      }
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
    }

    public static void postorder(Node root) {
      if (root == null) {
        return;
      }
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
    }

    public static void inorder(Node root) {
      if (root == null) {
        return;
      }
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }

    public static void levelorder(Node root) {
      if (root == null) {
        return;
      }
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      q.add(null);
      while (!q.isEmpty()) {
        Node currNode = q.remove();
        if (currNode == null) {
          System.out.println();
          if (q.isEmpty()) {
            break;
          } else {
            q.add(null);
          }
        } else {
          System.out.print(currNode.data + " ");
          if (currNode.left != null) {
            q.add(currNode.left);
          }
          if (currNode.right != null) {
            q.add(currNode.right);
          }
        }

      }
    }

    public static int height(Node root) {
      if (root == null) {
        return 0;
      }
      return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int nodeCount(Node root) {
      if (root == null) {
        return 0;
      }
      return nodeCount(root.left) + nodeCount(root.right) + 1;
    }

    public static int sumOfNodes(Node root) {
      if (root == null) {
        return 0;
      }
      return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public static int diameter(Node root) {// O(n2)
      if (root == null) {
        return 0;
      }
      int ldiam = diameter(root.left);
      int rdiam = diameter(root.right);
      return Math.max(Math.max(ldiam, rdiam), height(root.left) + height(root.right) + 1);
    }
  }

  // diameter of a tree
  static class Info {
    int diam;
    int ht;

    Info(int d, int ht) {
      this.diam = d;
      this.ht = ht;
    }
  }

  public static Info diameter(Node root) {// O(n)
    if (root == null) {
      return new Info(0, 0);
    }
    Info linfo = diameter(root.left);
    Info rinfo = diameter(root.right);
    int finalDiam = Math.max(Math.max(linfo.diam, rinfo.diam), linfo.ht + rinfo.ht + 1);
    int height = Math.max(linfo.ht, rinfo.ht) + 1;
    return new Info(finalDiam, height);
  }

  // check subtree
  public static boolean isIdentical(Node node, Node subRoot) {
    if (node == null && subRoot == null) {
      return true;
    } else if (node == null || subRoot == null || node.data != subRoot.data) {
      return false;
    }
    if (!isIdentical(node.left, subRoot.left)) {
      return false;
    }
    if (!isIdentical(node.right, subRoot.right)) {
      return false;
    }
    return true;
  }

  public static boolean isSubTree(Node root, Node subRoot) {
    if (root == null) {
      return false;
    }
    if (root.data == subRoot.data) {
      if (isIdentical(root, subRoot)) {
        return true;
      }
    }
    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }

  // topview of a tree
  public static class info {
    Node node;
    int hd;

    info(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  public static void topView(Node root) {
    if (root == null) {
      return;
    }
    Queue<info> q = new LinkedList<>();
    HashMap<Integer, Node> map = new HashMap<>();
    int min = 0, max = 0;
    q.add(new info(root, 0));
    q.add(null);
    while (!q.isEmpty()) {
      info curr = q.remove();
      if (curr == null) {
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else {
        // add new value in map
        if (!map.containsKey(curr.hd)) {
          map.put(curr.hd, curr.node);
        }

        if (curr.node.left != null) {
          q.add(new info(curr.node.left, curr.hd - 1));
          min = Math.min(min, curr.hd - 1);
        }
        if (curr.node.right != null) {
          q.add(new info(curr.node.right, curr.hd + 1));
          max = Math.max(max, curr.hd + 1);
        }
      }
    }
    for (int i = min; i <= max; i++) {
      System.out.print(map.get(i).data + " ");
    }
  }

  // PRINT KTH LEVEL
  public static void kthLevelIteration(Node root, int k) {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    int level = 1;
    while (!q.isEmpty()) {
      Node currNode = q.remove();
      if (currNode == null) {
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
          level++;
        }
      } else {
        if (level == k) {
          System.out.print(currNode.data + " ");
        }
        if (currNode.left != null) {
          q.add(currNode.left);
        }
        if (currNode.right != null) {
          q.add(currNode.right);
        }
      }

    }
  }

  public static void kthLevelRecursive(Node root, int level, int k) {
    if (root == null) {
      return;
    }
    if (level == k) {
      System.out.print(root.data + " ");
      return;
    }
    kthLevelRecursive(root.left, level + 1, k);
    kthLevelRecursive(root.right, level + 1, k);
  }

  // lowest common ancestor
  public static boolean getPathToNode(Node root, int key, ArrayList<Integer> path) {
    if (root == null) {
      return false;
    }
    path.add(root.data);
    if (root.data == key) {
      return true;
    }
    if (getPathToNode(root.left, key, path) || getPathToNode(root.right, key, path)) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }

  public static int lowestCommonAncestor(Node root, int n1, int n2) {
    ArrayList<Integer> path1 = new ArrayList<>();
    ArrayList<Integer> path2 = new ArrayList<>();
    getPathToNode(root, n1, path1);
    getPathToNode(root, n2, path2);
    int i = 0;
    for (; i < path1.size() && i < path2.size(); i++) {
      if (path1.get(i) != path2.get(i)) {
        break;
      }
    }
    return path1.get(i - 1);

  }

  public static Node lca(Node root, int n1, int n2) {
    if (root == null || root.data == n1 || root.data == n2) {
      return root;
    }
    Node leftLCA = lca(root.left, n1, n2);
    Node rightLCA = lca(root.right, n1, n2);
    if (leftLCA == null) {
      return rightLCA;
    }
    if (rightLCA == null) {
      return leftLCA;
    }
    return root;
  }

  // min daitance
  public static int distance(Node root, int n) {
    if (root == null) {
      return -1;
    }
    if (root.data == n) {
      return 0;
    }
    int leftdist = distance(root.left, n);
    int rightdist = distance(root.right, n);
    if (leftdist == -1 && rightdist == -1) {
      return -1;
    } else if (leftdist >= 0) {
      return leftdist + 1;
    } else {
      return rightdist + 1;
    }
  }

  public static int minDistance(Node root, int n1, int n2) {
    Node lca = lca(root, n1, n2);
    int dist1 = distance(lca, n1);
    int dist2 = distance(lca, n2);
    return dist1 + dist2;
  }

  //kth ancestor
  public static int kthAncestor(Node root,int n,int k){
    if(root==null){
      return -1;
    }
    if(root.data==n){
      return 0;
    }
    int leftdist=kthAncestor(root.left,n, k);
    int rightdist=kthAncestor(root.right,n, k);
    if(leftdist==-1&&rightdist==-1){
      return -1;
    }
    int dist=Math.max(leftdist,rightdist);
    if(dist+1==k){
      System.out.println(root.data);
    }
    return dist+1;
  }

  public static int sumTree(Node root){
    if(root==null){
      return 0;
    }
    int curr;
    curr=root.data;
    if(root.left==null&&root.right==null){
      root.data=0;
      return curr;
    }
    root.data=sumTree(root.left)+sumTree(root.right);
    return root.data+curr;

  }
  public static void main(String[] args) {
    int nodes[] = { 8, 6, 5, 3, -1, -1, -1, -1, 10, -1, 11, -1, 15, -1, -1 };

    Tree t = new Tree();
    Node root = t.BuildTree(nodes);

    t.preorder(root);
    System.out.println();
    t.inorder(root);
    System.out.println();
    // System.out.println(lowestCommonAncestor(root, 11, 5));
    // System.out.println(lca(root, 11, 5).data);
    // System.out.println(minDistance(root, 3, 15));
    // kthAncestor(root, 11, 2);
    // kthAncestor(root, 3, 3);
    sumTree(root);
    t.preorder(root);  
    // kthLevelIteration(root, 2);
    // kthLevelRecursive(root, 1,2);
    // System.out.println();
    // topView(root);
    // Node subroot = new Node(10);
    // subroot.right = new Node(11);
    // subroot.right.right = new Node(15);

    // if (isSubTree(root, subroot)) {
    // System.out.println("Yes! it is subtree");
    // } else {
    // System.out.println("No! it is not a subtree");
    // }
    // System.out.println();
    // t.postorder(root);
    // System.out.println();
    // t.levelorder(root);
    // System.out.println(t.height(root));
    // System.out.println(t.nodeCount(root));
    // System.out.println(t.sumOfNodes(root));
    // System.out.println(diameter(root).diam + " ");
  }
}