
//PARTIALLY CORRECT
package zadaca3;

import java.util.*;

class Gragjanin {
    String imePrezime;
    int licna_karta;
    int pasosi;
    int vozacka_dozvola;

    public Gragjanin(String imePrezime, int licna_karta, int pasosi, int vozacka_dozvola) {
        this.imePrezime = imePrezime;
        this.licna_karta = licna_karta;
        this.pasosi = pasosi;
        this.vozacka_dozvola = vozacka_dozvola;
    }
}

public class MVR {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());
        Queue<Gragjanin> licnaKarta = new LinkedList<>();
        Queue<Gragjanin> pasosi = new LinkedList<>();
        Queue<Gragjanin> vozacki = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);

            if (covek.licna_karta == 1) {
                licnaKarta.add(covek);
            }
            if (covek.pasosi == 1 && covek.licna_karta != 1) {
                licnaKarta.remove(covek);
                pasosi.add(covek);
            }
            if (covek.vozacka_dozvola == 1 && covek.licna_karta != 1 && covek.pasosi != 1) {
                vozacki.add(covek);
            }
        }

        while (!licnaKarta.isEmpty()) {
            Gragjanin person = licnaKarta.poll();
            System.out.println(person.imePrezime);
        }
        while (!pasosi.isEmpty()) {
            Gragjanin person = pasosi.poll();
            System.out.println(person.imePrezime);
        }
        while (!vozacki.isEmpty()) {
            Gragjanin person = vozacki.poll();
            System.out.println(person.imePrezime);
        }
    }
}
