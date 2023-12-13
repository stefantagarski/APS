package zadaca1;


import java.io.*;
import java.util.*;

interface Tree<E> {
    ////////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator ////////////
    public Iterator<E> children(Node<E> node);

}

interface Node<E> {

    public E getElement();

    public void setElement(E elem);
}


class SLLTree<E> implements Tree<E> {

    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {

        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i = 0; i < level; i++)
            System.out.print(" ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>) node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level + 1);
            tmp = tmp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, 0);
    }

}

class SLLNode<P> implements Node<P> {

    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }

}

public class WindowsExplorer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];

        for (int i = 0; i < N; i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<>();
        tree.makeRoot("c:");

        SLLNode<String> root;
        SLLNode<String> current;

        for (String command : commands) {
            String[] parts = command.split("\\s+");

            if ("CREATE".equals(parts[0])) {

                root = (SLLNode<String>) tree.root();
                current = root.firstChild;
                boolean flag = false;

                if (current == null) {
                    root.firstChild = new SLLNode<>(parts[1]);
                    root.firstChild.parent = root;
                } else if (current.getElement().compareTo(parts[1]) > 0) {
                    root.firstChild = new SLLNode<>(parts[1]);
                    root.firstChild.parent = current.parent;
                    root.firstChild.sibling = current;
                }

                else {
                    while (current.sibling != null) {
                        if (current.sibling.getElement().compareTo(parts[1]) > 0) {
                            SLLNode<String> node = new SLLNode<>(parts[1]);
                            node.sibling = current.sibling;
                            current.sibling = node;
                            node.parent = current.parent;
                            flag = true;
                            break;
                        }
                        current = current.sibling;
                    }

                    if (!flag) {
                        current.sibling = new SLLNode<>(parts[1]);
                        current.sibling.parent = current.parent;
                    }
                }
            } else if ("OPEN".equals(parts[0])) {
                root = (SLLNode<String>) tree.root();
                current = root.firstChild;

                while (current != null) {
                    if (current.getElement().equals(parts[1])) {
                        tree.root = current;
                        break;
                    }
                    current = current.sibling;
                }
            } else if ("BACK".equals(parts[0])) {
                tree.root = tree.root.parent;
            } else if ("PATH".equals(parts[0])) {
                root = (SLLNode<String>) tree.root();
                Stack<String> path = new Stack<>();

                while (root != null) {
                    path.push(root.element);
                    root = root.parent;
                }

                while (!path.isEmpty()) {
                    System.out.print(path.pop());
                    System.out.print("\\");
                }
                System.out.println();

            } else if ("DELETE".equals(parts[0])) {
                root = (SLLNode<String>) tree.root();
                current = root.firstChild;

                while (current != null) {
                    if (current.getElement().equals(parts[1])) {
                        break;
                    }
                    current = current.sibling;
                }

                tree.remove(current);
            } else if ("PRINT".equals(parts[0])) {
                root = (SLLNode<String>) tree.root();

                while (root.parent != null) {
                    root = root.parent;
                }

                tree.printTreeRecursive(root, 0);
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}