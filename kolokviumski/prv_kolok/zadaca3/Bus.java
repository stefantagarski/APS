package zadaca3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka

        int max,min;

        min = Math.max(N, M);

        if (M == 0) {
            max = N;
        }
        else
            max = N+M-1;

        System.out.println(min*100);
        System.out.println(max*100);


    }

}
