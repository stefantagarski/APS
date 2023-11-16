package zadaca1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {
    static int presmetaj(char[] c, int l, int r) {
        if (l == r) {
            return c[l] - '0';
        }

        int zagradi = 0;
        int operationIdx = -1;

        for (int i = l; i <= r; i++) {
            if (c[i] == '(') {
                zagradi++;
            } else if (c[i] == ')') {
                zagradi--;
            } else if (zagradi == 0 && (c[i] == '+' || c[i] == '-')) {
                operationIdx = i;
                break;
            }
        }

        if (operationIdx != -1) {
            // r index se postavuva na posledniot karakter od desniot del posle operatorot
            int left = presmetaj(c, l, operationIdx - 1);
            // l index se postavuva na prviot karakter od leviot del pred operatorot
            int right = presmetaj(c, operationIdx + 1, r);

            if (c[operationIdx] == '+') {
                return left + right;
            } else {
                return left - right;
            }
        } else {
            return presmetaj(c, l + 1, r - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        char[] exp = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length - 1);
        System.out.println(rez);

        br.close();
    }
}