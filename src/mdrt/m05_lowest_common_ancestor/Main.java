package mdrt.m05_lowest_common_ancestor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main implements Runnable {
    private final String fileName;

    public Main(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws IOException {
        final Bst bst = new Bst();
        final int[] data = new int[]{30, 8, 52, 3, 20, 10, 29};
        for (int x : data) {
            bst.add(x);
        }

        final BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                final String[] strArray = line.split(" ");
                final int v1 = Integer.parseInt(strArray[0]);
                final int v2 = Integer.parseInt(strArray[1]);
                final int[] a1 = bst.ancestor(v1);
                final int[] a2 = bst.ancestor(v2);
                boolean result = false;
                for (int i = a1.length - 1; i >= 0 && !result; i--) {
                    for (int j = a2.length - 1; j >= 0 && !result; j--) {
                        if (a1[i] == a2[j]) {
                            System.out.println(a1[i]);
                            result = true;
                        }
                    }
                }
            }
        }
        in.close();
    }


    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

class Bst {
    private Node root;

    public void add(int x) {
        root = add(root, x);
    }

    private Node add(Node node, int x) {
        if (node == null) {
            node = new Node(x);
        } else if (x < node.val) {
            node.left = add(node.left, x);
        } else if (x > node.val) {
            node.right = add(node.right, x);
        } else {
            return null;
        }
        return node;
    }

    public int[] ancestor(int x) {
        return ancestor(root, x, new int[]{});
    }

    public int[] ancestor(Node node, int x, int[] seq) {
        seq = Arrays.copyOf(seq, seq.length + 1);
        seq[seq.length - 1] = node.val;
        if (node.val == x) {
            return seq;
        } else {
            if (x < node.val) {
                return ancestor(node.left, x, seq);
            } else if (x > node.val) {
                return ancestor(node.right, x, seq);
            } else {
                return null;
            }
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node.left != null) {
            printTree(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            printTree(node.right);
        }
    }

    private class Node {
        private int val;
        private Node left, right;

        public Node(int x) {
            this.val = x;
        }
    }
}
