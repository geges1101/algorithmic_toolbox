//package com.company;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        numberOfInversions += merge(a, b,left, ave - 1, ave, right - 1);
        return numberOfInversions;
    }

    private static long merge(int[] a, int[] b, int start, int mid, int l2, int end){
        int count = 0;

        int i = start;
        int j = l2;
        int pos = start;

        while (i <= mid && j <= end){
            if(a[i] <= a[j]) b[pos++] = a[i++];
            else{
                count += mid - i + 1;
                b[pos++] = a[j++];
            }
        }
        for(int idx = i; idx <= mid; idx++) b[pos++] = a[idx];
        for(int idx = j; idx <= end; idx++) b[pos++] = a[idx];

        for(int idx = start; idx <= end; idx++) a[idx] = b[idx];

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}