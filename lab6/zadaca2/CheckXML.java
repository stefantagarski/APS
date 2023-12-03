package zadaca2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class XMLValidator {

        public static int validate(String[] xml) {
            int valid = 1;
            Stack<String> stack = new Stack<>();
            for (String line : xml) {
                if (line.startsWith("[")) {
                    if (line.startsWith("[/")) {
                            String tag = stack.pop();
                            if (!tag.equals(line.substring(2, line.length() - 1))) {
                                valid = 0;
                                break;
                            }
                    } else {
                        stack.push(line.substring(1, line.length() - 1));
                    }
                }
            }
            if (!stack.isEmpty()) {
                valid = 0;
            }
            return valid;
        }

}

public class CheckXML {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid;

        valid = XMLValidator.validate(redovi);


        System.out.println(valid);

        br.close();
    }
}