import java.math.BigInteger;
import java.util.Arrays;

/*
* 1175. 质数排列
* */
public class leetcode1175 {

    public static int numPrimeArrangements(int n) {
        int num1 = 0, num2 = 1;
        for(int i = 2; i <= n; i++){
            if(isPrimeNumber(i)){
                num1++;
            }else{
                num2++;
            }
        }
        long sum1 = 1, sum2 = 1;
        for(int i = 1; i <= num1; i++){
            sum1 *= i;
            sum1 %= (1000000007);
        }
        for(int i = 1; i <= num2; i++){
            sum2 *= i;
            sum2 %= (1000000007);
        }
        return (int)(sum1 * sum2 % (1000000007)) ;
        
    }
    public static boolean isPrimeNumber(int n){
        int s = (int) Math.sqrt(n);
        for(int i = s; i > 1; i--){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(100));
    }

}
