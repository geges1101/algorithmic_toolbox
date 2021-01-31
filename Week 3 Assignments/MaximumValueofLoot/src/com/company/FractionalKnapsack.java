//package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double [] ratios = new double[values.length];

        for(int i = 0; i != ratios.length; i++){
            double v = values[i];
            double w = weights[i];
            ratios[i] = v / w;
        }

        int item_count = ratios.length;

        while(capacity > 0 && item_count != 0){
            double max = 0;
            int max_idx = 0;

            for(int i = 0; i != ratios.length; i++){
                if(ratios[i] > max){
                    max = ratios[i];
                    max_idx = i;
                }
            }
            ratios[max_idx] = 0;
            double curr_weight = weights[max_idx];
            double curr_value = values[max_idx];

            if(weights[max_idx] > capacity){
               double over = capacity / curr_weight;
              value += over * curr_value;
              capacity = 0;
            }

            else {
                capacity -= curr_weight;
                value += curr_value;
                item_count--;
            }

        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}