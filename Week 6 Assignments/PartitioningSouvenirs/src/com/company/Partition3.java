//package com.company;

import java.util.*;


public class Partition3 {

    private static int partition3(int[] A) {
        int n = A.length;
        if (n < 3)
            return 0;
        int i,sum = 0;

        for(i = 0; i != n; i++) sum+=A[i];

        if(sum % 3 != 0) return 0;

        if(subProblem(A, n, sum / 3)) return 1;
        return 0;
    }

    static boolean subProblem(int a[], int n, int sum) {
        if (sum == 0) return true;

        if (n == 0 && sum != 0) return false;

        if (a[n - 1] > sum) return subProblem(a, n - 1, sum);

        return subProblem(a, n - 1, sum) || subProblem(a, n - 1, sum - a[n - 1]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}