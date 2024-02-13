package zadaca18;


import java.util.Scanner;

class SLLNode {
    String name;
    int price;
    SLLNode succ;

    public SLLNode(String name, int price, SLLNode succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SLLNode ins = new SLLNode(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class CakeShop {

    public static void removeCakes(SLL cakes) {
        // TODO: implement method

        SLLNode node = cakes.first;

        double sum = 0;
        int count = 0;

        while (node != null) {
            sum += node.price;
            count++;
            node = node.succ;
        }
        double avg = sum / count;

        SLLNode prev = null;
        node = cakes.first;

        while (node != null) {
            if (node.price > avg){
                if (prev == null) {
                    node = node.succ;
                }else {
                    prev.succ = node.succ;
                }
            }else {
                prev = node;
            }
            node = node.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL cakes = new SLL();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes);
    }
}
//6
//Jagoda 500
//Cresha 800
//Meshana 300
//ChokoladoKaramela 5500
//Vanilla 4000
//Vishna 7500