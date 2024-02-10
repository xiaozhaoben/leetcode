package nowcode.HJ;

import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        long k = (long) Math.sqrt(num);
        for (long i = 2; i <= k; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
            }
        }
        System.out.print(num == 1 ? "" : num + " ");
    }
}
