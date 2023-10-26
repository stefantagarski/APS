package labs.lab1;

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        String reversed = " ";
        for (int i = 0; i < word.length(); i++) {
            reversed = word.charAt(i) + reversed;
        }
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            printReversed(word);
        }


    }
}

