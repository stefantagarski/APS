package zadaca4;

import java.util.*;
import java.io.*;


class Lek {
    String ime;
    int pozLista;
    int cena;
    int kolicina;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getPozLista() {
        return pozLista;
    }

    public Lek(String ime, int pozLista, int cena, int kolicina) {
        this.ime = ime.toUpperCase();
        this.pozLista = pozLista;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        if (pozLista == 1) return ime + "\n" + "POZ\n" + cena + "\n" + kolicina;
        else return ime + "\n" + "NEG\n" + cena + "\n" + kolicina;
    }
}

class LekKluch {
    String ime;

    public LekKluch(String ime) {
        this.ime = ime.toUpperCase();
    }

    @Override
    public int hashCode() {
        if (ime.length() == 1) {
            return (29 * (29 * ((int) ime.charAt(0)))) % 102780;
        } else if (ime.length() == 2) {
            return (29 * (29 * ((int) ime.charAt(0) + (int) ime.charAt(1)) + (int) ime.charAt(0))) % 102780;
        }
        return (29 * (29 * ((int) ime.charAt(0) + (int) ime.charAt(1) + (int) ime.charAt(2)))) % 102780;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LekKluch lekKluch = (LekKluch) o;
        return Objects.equals(ime, lekKluch.ime);
    }
}


public class Apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        CBHT<LekKluch, Lek> hashTable = new CBHT<>(N * 2);

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            String ime = parts[0];
            int pozLista = Integer.parseInt(parts[1]);
            int cena = Integer.parseInt(parts[2]);
            int kolicina = Integer.parseInt(parts[3]);
            Lek lek = new Lek(ime, pozLista, cena, kolicina);
            LekKluch kluc = new LekKluch(ime);
            hashTable.insert(kluc, lek);
        }

        String input;
        while (!(input = br.readLine()).equals("KRAJ")) {
            String[] order = input.split(" ");
            LekKluch kluc = new LekKluch(order[0]);
            SLLNode<MapEntry<LekKluch, Lek>> searchResult = hashTable.search(kluc);
            if (searchResult != null) {
                Lek lek = searchResult.element.value;
                if (lek != null) {
                    int orderAmount = Integer.parseInt(order[1]);
                    if (orderAmount > lek.getKolicina()) {
                        System.out.println("Nema dovolno lekovi");
                    } else {
                        lek.setKolicina(lek.getKolicina() - orderAmount);
                        System.out.println(lek.getIme() + " " + (lek.getPozLista() == 1 ? "POZ" : "NEG") + " " + lek.getCena() + " " + lek.getKolicina());
                        System.out.println("Napravena naracka");
                    }
                }
            } else {
                System.out.println("Nema takov lek");
            }
        }
    }
}


class CBHT<K, E> {
    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(curr.element.key)) return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(curr.element.key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(curr.element.key)) {
                if (pred == null) buckets[b] = curr.succ;
                else pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}

class MapEntry<K, E> {
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
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