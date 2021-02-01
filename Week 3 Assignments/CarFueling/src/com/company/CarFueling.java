package com.company;

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        if (tank > dist)
            return 0;

        int refill_count = 0;
        int current_stop = 0;

        //next_in_reach confirms whether the we have at least 1 stop in reach of full tank
        // from the current stop
        boolean next_in_reach = false;
        int idx = 0;

        while(stops[current_stop + idx] < tank){
            if(!next_in_reach) next_in_reach = true;
            idx++;
        }
        current_stop += idx - 1;

        if(!next_in_reach) tank = 0;
        else refill_count++;

        while(stops[current_stop] + tank < dist && tank != 0){
            next_in_reach = false;
            int reachable_stop = 0;

          for(int i = current_stop; i != stops.length; i++){
                if(stops[i] - stops[current_stop] < tank){
                    if(!next_in_reach) next_in_reach = true;
                    reachable_stop = i - 1;
                }
                else{
                    if(!next_in_reach) tank = 0;
                    current_stop = i - 1;
                    refill_count++;
                    next_in_reach = false;
                    reachable_stop = current_stop;
                }
            }
          current_stop = reachable_stop;
            refill_count++;
        }
        if(tank > 0) return refill_count;
        return -1;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
