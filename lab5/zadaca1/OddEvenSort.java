package zadaca1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class OddEvenSort {

    static void oddEvenSort(int[] a, int n) {
        Integer[] odd = new Integer[n];
        Integer[] even = new Integer[n];
        int oddCount = 0, evenCount = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                odd[oddCount++] = a[i];
            } else {
                even[evenCount++] = a[i];
            }
        }

        Arrays.sort(odd, 0, oddCount);
        Arrays.sort(even, 0, evenCount, Comparator.reverseOrder());

        int i = 0;
        for (int j = 0; j < oddCount; j++) {
            a[i++] = odd[j];
        }
        for (int j = 0; j < evenCount; j++) {
            a[i++] = even[j];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int i;

        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);

        oddEvenSort(a, n);

        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}
