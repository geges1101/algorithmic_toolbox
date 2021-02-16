//package com.company;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        if(m < 3) return m;

        int[] values = new int[m + 1];

        values[0] = 0;
        values[1] = 1;
        values[2] = 2;
        values[3] = 1;

        for(int i = 4; i != values.length; i++){
            values[i] = Math.min(values[i - 1],
                        Math.min(values[i - 3],values[i - 4])) + 1;
        }
        return values[m];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


