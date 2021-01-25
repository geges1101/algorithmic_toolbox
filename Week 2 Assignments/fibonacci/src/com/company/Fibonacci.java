import java.util.Scanner;

public class Fibonacci {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 0)
        {
            System.out.println(0);
            System.exit(0);
        }

        long nums[] ={ 0,1};
        long num;
        for(int i = 2; i != n + 1; i++)
        {
            num = nums[1];
            nums[1] = nums[1] + nums[0];
            nums[0] = num;
        }
        System.out.println(nums[1]);
    }
}
