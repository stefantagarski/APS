package zadaca2;


import java.util.Scanner;

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


class OBHT<K extends Comparable<K>,E> {

    private final MapEntry<K,E>[] buckets;

    static final int NONE = -1;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final MapEntry former = new MapEntry(null, null);

    private int occupancy = 0;

    @SuppressWarnings("unchecked")
    public OBHT (int m) {
        buckets = (MapEntry<K,E>[]) new MapEntry[m];
    }

    private int hash (K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public MapEntry<K,E> getBucket(int i){
        return buckets[i];
    }


    public int search (K targetKey) {
        int b = hash(targetKey);
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return NONE;
            else if (targetKey.equals(oldEntry.key))
                return b;
            else
                b = (b + 1) % buckets.length;
        }
    }


    public void insert (K key, E val) {
        MapEntry<K,E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null) {
                if (++occupancy == buckets.length) {
                    System.out.println("Hash tabelata e polna!!!");
                }
                buckets[b] = newEntry;
                return;
            } else if (oldEntry == former
                    || key.equals(oldEntry.key)) {
                buckets[b] = newEntry;
                return;
            } else
                b = (b + 1) % buckets.length;
        }
    }


    @SuppressWarnings("unchecked")
    public void delete (K key) {
        int b = hash(key);
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return;
            else if (key.equals(oldEntry.key)) {
                buckets[b] = former;
                return;
            } else{
                b = (b + 1) % buckets.length;
            }
        }
    }


    public String toString () {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            temp.append(i).append(":");
            if (buckets[i] == null)
                temp.append("\n");
            else if (buckets[i] == former)
                temp.append("former\n");
            else
                temp.append(buckets[i]).append("\n");
        }
        return temp.toString();
    }


//    public OBHT<K,E> clone () {
//        OBHT<K,E> copy = new OBHT<K,E>(buckets.length);
//        for (int i = 0; i < buckets.length; i++) {
//            MapEntry<K,E> e = buckets[i];
//            if (e != null&&e != former)
//                copy.buckets[i] = new MapEntry<K,E>(e.key, e.value);
//            else
//                copy.buckets[i] = e;
//        }
//        return copy;
//    }
}



public class Preveduvac {
    public static void main (String[] args){

       Scanner scanner = new Scanner(System.in);
        OBHT<String, String> map = new OBHT<>(128);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] pom = line.split(" ");
            //before machka cat
            map.insert(pom[1],pom[0]);
            //after cat machka
        }

        while (true){
            String line = scanner.nextLine();
            if (line.equals("KRAJ")) {
                break;
            }
            int search = map.search(line);
            if (search != -1) {
                System.out.println(map.getBucket(search).value);
        }
        else {
                System.out.println("/");
            }
        }
    }
}
