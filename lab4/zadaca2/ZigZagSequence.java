package zadaca2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int[] a) {
        if (a.length <= 2) {
            return 1;
        }
        int counter = 1;
        int maxLen = 1;

        for (int i = 1; i < a.length; i++) {
            if ((a[i] > 0 && a[i - 1] < 0) || (a[i] < 0 && a[i - 1] > 0)) {
                counter++;
                maxLen = Math.max(counter,maxLen);

            }

            else {
                counter = 1;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
