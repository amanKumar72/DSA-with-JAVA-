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

  public static int diameter(Node root){//O(n2)
    if(root==null){
      return 0;
    }
    int ldiam=diameter(root.left);
    int rdiam=diameter(root.right);
    return Math.max(Math.max(ldiam,rdiam),height(root.left)+height(root.right)+1);
  }
  }

  static class Info {
    int diam;
    int ht;

    Info(int d, int ht) {
      this.diam = d;
      this.ht = ht;
    }
  }

  public static Info diameter(Node root) {//O(n)
    if (root == null) {
      return new Info(0, 0);
    }
    Info linfo = diameter(root.left);
    Info rinfo = diameter(root.right);
    int finalDiam = Math.max(Math.max(linfo.diam, rinfo.diam), linfo.ht + rinfo.ht + 1);
    int height = Math.max(linfo.ht, rinfo.ht) + 1;
    return new Info(finalDiam, height);
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    Tree t = new Tree();
    Node root = t.BuildTree(nodes);
    t.preorder(root);
    System.out.println();
    t.inorder(root);
    System.out.println();
    t.postorder(root);
    System.out.println();
    t.levelorder(root);
    System.out.println(t.height(root));
    System.out.println(t.nodeCount(root));
    System.out.println(t.sumOfNodes(root));
    System.out.println(diameter(root).diam+" ");
  }
}