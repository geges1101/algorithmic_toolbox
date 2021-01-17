//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a, b;
        Scanner input = new Scanner(System.in);

        a = input.nextInt();
        b = input.nextInt();

        System.out.println(a + b);

        input.close();
    }
}
