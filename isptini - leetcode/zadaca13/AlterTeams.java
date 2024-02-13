package zadaca13;

import java.util.Scanner;

class SLLNode {
    int id;
    int age;
    SLLNode succ;

    public SLLNode(int id, int age, SLLNode succ) {
        this.id = id;
        this.age = age;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;
    }

    public void deleteFirst() {
        if (first != null) {
            SLLNode tmp = first;
            first = first.succ;
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void delete(SLLNode node) {
        if (first != null) {
            SLLNode tmp = first;
            if (first == node) {
                this.deleteFirst();
                return;
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }

    }

    public void insertFirst(int id, int age) {
        SLLNode ins = new SLLNode(id, age, first);
        first = ins;
    }

    public void insertAfter(int id, int age, SLLNode node) {
        if (node != null) {
            SLLNode ins = new SLLNode(id, age, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(int id, int age, SLLNode before) {

        if (first != null) {
            SLLNode tmp = first;
            if (first == before) {
                this.insertFirst(id, age);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode ins = new SLLNode(id, age, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }


    public void insertLast(int id, int age) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, age, null);
            tmp.succ = ins;
        } else {
            insertFirst(id, age);
        }
    }

    public SLLNode getFirst() {
        return first;
    }

    @Override
    public String toString() {
        String s = "";
        SLLNode dvizi = first;
        while (dvizi != null) {
            s = s + dvizi.id + " ";
            dvizi = dvizi.succ;
        }
        return s;
    }
}

public class AlterTeams {
    public static void alterTeams(SLL devTeam, SLL qaTeam) {
        SLLNode nodeDev = devTeam.getFirst();
        SLLNode nodeQa = qaTeam.getFirst();

        if (devTeam.length() == 0) {
            return;
        }
        if (qaTeam.length() == 0) {
            return;
        }

        int min = 999;
        SLLNode minWorker = null;

        while (nodeQa != null) {
            if (nodeQa.age < min) {
                min = nodeDev.age;
                minWorker = nodeQa;
            }
            nodeQa = nodeQa.succ;
        }
        qaTeam.delete(minWorker);

        int size;
        if (devTeam.length() % 2 == 0) {
            size = devTeam.length() / 2;
        } else {
            size = devTeam.length() / 2 + 1;
        }

        int i = 0;
        while (i < size) {
            nodeDev = nodeDev.succ;
            i++;
        }
        devTeam.insertBefore(minWorker.id, minWorker.age, nodeDev);
    }

    public static void main(String[] args) {
        SLL dev = new SLL();
        SLL qa = new SLL();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        for (int i = 0; i < n; i++) {
            int id = input.nextInt();
            int age = input.nextInt();
            dev.insertLast(id, age);
        }

        for (int i = 0; i < m; i++) {
            int id = input.nextInt();
            int age = input.nextInt();
            qa.insertLast(id, age);
        }

        alterTeams(dev, qa);
        System.out.println(dev);
        System.out.println(qa);
    }
}

//2
//3
//16100 20
//17200 30
//19898 20
//14203 35
//18100 19
//
//3
//3
//16100 20
//17200 30
//18112 45
//14102 19
//19203 35
//18900 20