
import java.util.ArrayList;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] coins = new int[]{1,5,10};

        int count = 1;
        int sum = 10;
        int idx = 2;

        while(sum != m){
            if(sum > m){
                sum -= coins[idx];
                idx--;
                sum += coins[idx];
            }
            else{
                sum += coins[idx];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


