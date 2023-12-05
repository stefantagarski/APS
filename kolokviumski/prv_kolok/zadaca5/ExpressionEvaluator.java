package zadaca5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:
    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private final E[] elems; //elems[0...depth-1] se negovite elementi.
    private int depth; //depth e dlabochinata na stekot

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException(); //return null;
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }

    public int size() {
        // Ja vrakja dolzinata na stack-ot.
        return depth;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException(); //return null;
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class ExpressionEvaluator {

    public static int evaluateExpression(char[] a) {
        ArrayStack<Integer> stack = new ArrayStack<>(100);

        //2+2*2*2*2*2*2+2*2

        int number = 0;
        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i]) && Character.isDigit(a[i + 1])) {
                number = number * 10 + Character.getNumericValue(a[i]);

            }
            if (Character.isDigit(a[i]) && !Character.isDigit(a[i + 1])) {
                number = number * 10 + Character.getNumericValue(a[i]);
                stack.push(number);
                number = 0;

            }

            if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') {
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (a[i] =='*') {
                    stack.push(num1 + num2);
                }

                else if (a[i] =='+') {
                    stack.push(num1 * num2);
                }
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        char[] c = s1.toCharArray();
        int res = ExpressionEvaluator.evaluateExpression(c);
        System.out.println(res);
    }

}
