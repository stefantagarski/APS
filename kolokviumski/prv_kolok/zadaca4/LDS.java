package zadaca4;


import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        int max = 0;

        int[] niza = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            niza[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j] && niza[i] <= niza[j]) {
                    niza[i] = niza[j] + 1;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (niza[i] > max) {
                max = niza[i];
            }
        }


        return max;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
