package labs.lab1;

import java.util.Scanner;


class QuarterlySales {
    private int numOfSales;
    private int[] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }
}

class SalesPerson {
    private String name;
    private QuarterlySales[] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public String getName() {
        return name;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }
}

public class Main {
    private static int calculateQuarterlyRevenue(QuarterlySales qs) {
        int totalRevenue = 0;
        for (int revenue : qs.getRevenues()) {
            totalRevenue += revenue;
        }
        return totalRevenue;
    }

    public static int sumSales(SalesPerson sp) {
        int totalRevenue = 0;
        for (QuarterlySales qs : sp.getQuarters()) {
            totalRevenue += calculateQuarterlyRevenue(qs);
        }
        return totalRevenue;
    }

    public static SalesPerson salesChampion(SalesPerson[] arr) {
        SalesPerson champion = arr[0];
        int maxRevenue = sumSales(champion);

        for (int i = 1; i < arr.length; i++) {
            int revenue = sumSales(arr[i]);
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
                champion = arr[i];
            }
        }
        return champion;
    }

    public static void table(SalesPerson[] arr) {
        System.out.printf("%s   %s   %s   %s   %s   %s\n", "SP", "1", "2", "3", "4", "Total");
        for (SalesPerson sp : arr) {
            int[] quarterlyRevenues = new int[4];
            for (QuarterlySales qs : sp.getQuarters()) {
                quarterlyRevenues[qs.getQuarterNo() - 1] = calculateQuarterlyRevenue(qs);
            }
            int totalRevenue = sumSales(sp);
            System.out.printf("%s   %d   %d   %d   %d   %d\n", sp.getName(), quarterlyRevenues[0], quarterlyRevenues[1], quarterlyRevenues[2], quarterlyRevenues[3], totalRevenue);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SalesPerson[] arr = new SalesPerson[n];

        for (int i = 0; i < n; i++) {
            String name = input.next();
            QuarterlySales[] quarters = new QuarterlySales[4];
            for (int j = 0; j < 4; j++) {
                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];
                for (int k = 0; k < numOfSales; k++) {
                    revenues[k] = input.nextInt();
                }
                quarters[j] = new QuarterlySales(numOfSales, revenues, j + 1);
            }
            arr[i] = new SalesPerson(name, quarters);
        }

        table(arr);
        SalesPerson champion = salesChampion(arr);
        System.out.println();
        System.out.println("SALES CHAMPION: " + champion.getName());
    }
}
