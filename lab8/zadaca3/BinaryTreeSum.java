package zadaca3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}
@SuppressWarnings("unchecked")
class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }
}

@SuppressWarnings("unchecked")
public class BinaryTreeSum {

    public static BNode<Integer> findNode(BNode<Integer> node, int baranaVrednost) {
        if (node == null || node.info.equals(baranaVrednost)) {
            return node;
        }

        BNode<Integer> leftResult = findNode(node.left, baranaVrednost);
        if (leftResult != null) {
            return leftResult;
        }

        return findNode(node.right, baranaVrednost);
    }

    public static int sumNodesLeft(BNode<Integer> root, int baranaVrednost) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.info < baranaVrednost) {
            sum += root.info;
        }

        sum += sumNodesLeft(root.left, baranaVrednost);
        sum += sumNodesLeft(root.right, baranaVrednost);

        return sum;
    }

    public static int sumNodesRight(BNode<Integer> root, int baranaVrednost) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.info > baranaVrednost) {
            sum += root.info;
        }

        sum += sumNodesRight(root.left, baranaVrednost);
        sum += sumNodesRight(root.right, baranaVrednost);

        return sum;
    }



    public static void main(String[] args) throws Exception {
        int i;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer>[] nodes = new BNode[N];
        BTree<Integer> tree = new BTree<>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        int baranaVrednost = Integer.parseInt(br.readLine());

        br.close();


        BNode<Integer> root = tree.root;

        BNode<Integer> node = findNode(root, baranaVrednost);

        int left = sumNodesLeft(node.left, baranaVrednost);
        int right = sumNodesRight(node.right, baranaVrednost);


        System.out.println(left + " " + right);
    }



}
