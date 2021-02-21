//package com.company;

import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        if(s.equals(t)) return 0;

        int n = s.length() + 1;
        int m = t.length() + 1;

        if(n == m && n == 2){
            if(s.charAt(0) == t.charAt(0)) return 0;
            else return 1;
        }

        int[][] matrix = new int [n][m];
        matrix[0][0] = 0;

        int j = 0;
        for(int i = 1; i !=n; i++){
            matrix[i][j] = matrix[i - 1][j] + 1;
        }

        int i = 0;
        for(j = 1; j !=m; j++){
            matrix[i][j] = matrix[i][j - 1] + 1;
        }

        for(i = 1; i !=n; i++){
            for(j = 1; j !=m; j++){
                int deletion = matrix[i - 1][j] + 1;
                int insertion = matrix[i][j - 1] + 1;
                int match = matrix[i - 1][j - 1];
                int mismatch = matrix[i - 1][j - 1] + 1;

                if(s.charAt(i - 1) == t.charAt(j - 1)) matrix[i][j]
                        = Math.min(match,Math.min(deletion, insertion));
                else matrix[i][j]
                        = Math.min(mismatch,Math.min(deletion, insertion));
            }
        }

        return matrix[n - 1][m - 1];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}

