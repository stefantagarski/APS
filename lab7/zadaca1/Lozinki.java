package zadaca1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        Map<String, String> map = new HashMap<>();


        for (int i = 1; i <= N; i++) {
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            map.put(pom[0],pom[1]);
        }

        for (; ;) {
            String line = br.readLine();
            if (line.equals("KRAJ")) {
                break;
            }

            String[] parts = line.split(" ");
            if (map.containsKey(parts[0]) && map.get(parts[0]).equals(parts[1])) {
                System.out.println("Najaven");
                break;
            }else {
                System.out.println("Nenajaven");
            }

        }


    }
}
