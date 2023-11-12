package labs.lab1;

import java.util.Scanner;


public class PushZero {
    static void pushZerosToBeginning(int[] arr, int n) {
       int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                for (int j = i; j > count; j--) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        pushZerosToBeginning(arr, n);
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
