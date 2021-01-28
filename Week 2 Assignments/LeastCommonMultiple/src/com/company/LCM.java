import java.util.*;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long gcd_fast(long a, long b) {
        if(b == 0) return a;

        long remainder = a % b;

        return gcd_fast(b, remainder);
    }

    private static long lmc_fast(long a, long b) {
        return (a * b) / gcd_fast(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lmc_fast(a, b));
    }
}