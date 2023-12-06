package zadaca3;


import java.util.*;
import java.io.*;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    K key;
    E value;
    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
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



class CBHT<K extends Comparable<K>, E> {
    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }



    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            temp.append(i).append(":");
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp.append(curr.element.toString()).append(" ");
            }
            temp.append("\n");
        }
        return temp.toString();
    }
}

public class RoutingHashJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String[]> routingTable = new HashMap<>();

        int numRouters = Integer.parseInt(br.readLine());

        for (int i = 0; i < numRouters; i++) {
            String routerIP = br.readLine();
            String[] networks = br.readLine().split(",");
            routingTable.put(routerIP, networks);
        }

        int numAttempts = Integer.parseInt(br.readLine());

        for (int i = 0; i < numAttempts; i++) {
            String staticIP = br.readLine();
            String deviceIP = br.readLine();

            String[] targetIPs = routingTable.get(staticIP);

            if (targetIPs == null) {
                System.out.println("ne postoi");
                continue;
            }

            boolean valid = false;

            for (String targetIP : targetIPs) {
                String a = targetIP.substring(0, targetIP.lastIndexOf('.'));
                if (a.equals(deviceIP.substring(0, deviceIP.lastIndexOf('.')))) {
                    valid = true;
                    break;
                }
            }

            if (valid) {
                System.out.println("postoi");
            } else {
                System.out.println("ne postoi");
            }
        }
    }
}
