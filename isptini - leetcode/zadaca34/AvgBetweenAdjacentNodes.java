package zadaca34;

import java.util.Scanner;

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(new String());
        if (first != null) {
            DLLNode<E> tmp = first;
            ret.append(tmp);
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append("<->").append(tmp);
            }
        } else
            ret = new StringBuilder("Prazna lista!!!");
        return ret.toString();
    }

    public String toStringR() {
        StringBuilder ret = new StringBuilder(new String());
        if (last != null) {
            DLLNode<E> tmp = last;
            ret.append(tmp.toString());
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret.append("<->").append(tmp.toString());
            }
        } else
            ret = new StringBuilder("Prazna lista!!!");
        return ret.toString();
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public void mirror() {

        DLLNode<E> tmp = null;
        DLLNode<E> current = first;
        last = first;
        while (current != null) {
            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;
            current = current.pred;
        }

        if (tmp != null && tmp.pred != null) {
            first = tmp.pred;
        }
    }
}

public class AvgBetweenAdjacentNodes {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        insertAvg(list);
    }

    private static void insertAvg(DLL<Integer> list) {
        DLLNode<Integer> node = list.getFirst();
        DLLNode<Integer> next = list.getFirst().succ;

        while (node != null && next != null) {
            list.insertAfter(Math.round((float) (node.element + next.element) / 2),node);
            node = next;
            next = next.succ;
        }

        node = list.getFirst();
        while (node != null) {
            System.out.println(node.element + " ");
            node = node.succ;
        }
    }
}
