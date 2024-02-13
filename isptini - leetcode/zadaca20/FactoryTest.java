package zadaca20;

import java.util.Scanner;

class Order {
    private int id;
    private int product;
    private int priority;

    public Order(int id, int product, int priority) {
        this.id = id;
        this.product = product;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getProduct() {
        return product;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }


    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }


}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

public class FactoryTest {
    public static void orders(SLL<Order> active, SLL<Order> shipping) {

        for (int i = 0; i < 2; i++) {
            SLLNode<Order> node = active.getFirst();
            SLLNode<Order> maxPriority = null;
            int max = 999;
            while (node != null) {
                if (node.element.getPriority() <= max) {
                    max = node.element.getPriority();
                    maxPriority = node;
                }
                node = node.succ;
            }
            active.delete(maxPriority);
            shipping.insertLast(maxPriority.element);

        }
    }

    public static void main(String[] args) {
        SLL<Order> active = new SLL<>();
        SLL<Order> shipping = new SLL<>();
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < n; i++) {
            int id = input.nextInt();
            int product = input.nextInt();
            int priority = input.nextInt();
            Order nov = new Order(id, product, priority);
            active.insertLast(nov);
        }
        for (int i = 0; i < m; i++) {
            int id = input.nextInt();
            int product = input.nextInt();
            int priority = input.nextInt();
            Order nov2 = new Order(id, product, priority);
            shipping.insertLast(nov2);
        }

        orders(active, shipping);
        System.out.println(active);
        System.out.println(shipping);
    }
}
//3
//2
//550 991 2
//116 8695 2
//469 608 3
//491 355 3
//349 8380 7
//
//4
//2
//550 991 2
//116 865 2
//469 605 1
//505 123 5
//491 355 3
//349 8380 7
//
//6
//3
//550 991 2
//116 865 4
//469 605 1
//327 991 2
//505 123 3
//808 145 4
//500 129 5
//491 355 3
//349 8380 7