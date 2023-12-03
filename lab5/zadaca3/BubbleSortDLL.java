package zadaca3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node pred;
    Node succ;

    Node(int data) {
        this.data = data;
        pred = null;
        succ = null;
    }
}

public class BubbleSortDLL {
    static Node head;

    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.succ != null) {
                temp = temp.succ;
            }
            temp.succ = newNode;
            newNode.pred = temp;
        }
        return head;
    }

    static void bubbleSort(Node head) {
        if (head == null || head.succ == null) {
            return;
        }

        boolean swapped;
        Node last = null;

        do {
            swapped = false;
            Node current = head;

            while (current.succ != last) {
                if (current.data > current.succ.data) {
                    int temp = current.data;
                    current.data = current.succ.data;
                    current.succ.data = temp;
                    swapped = true;
                }
                current = current.succ;
            }
            last = current;
        } while (swapped);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] nodes = s.split(" ");

        for (int i = 0; i < n; i++) {
            head = insert(head, Integer.parseInt(nodes[i]));
        }

        bubbleSort(head);
        printList(head);
    }
}
