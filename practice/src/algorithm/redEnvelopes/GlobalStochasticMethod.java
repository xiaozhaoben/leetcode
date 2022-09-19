package algorithm.redEnvelopes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class GlobalStochasticMethod {
    public static void main(String[] args) {
        //初始化测试场景
        BigDecimal[][] rrr = {
                {new BigDecimal("0.1"), new BigDecimal("10")},
                {new BigDecimal("1"), new BigDecimal("10")},
                {new BigDecimal("100"), new BigDecimal("10")},
                {new BigDecimal("1000"), new BigDecimal("10")}
        };
        BigDecimal min = new BigDecimal("0.01");
        //测试个场景
        for (BigDecimal[] decimals : rrr) {
            final BigDecimal amount = decimals[0];
            final BigDecimal num = decimals[1];
            System.out.println(amount + "元" + num + "个人抢=======================================================");
            test3(amount, min, num);
        }
    }

    private static void test3(BigDecimal amount, BigDecimal min, BigDecimal num) {
        final Random random = new Random();
        final int[] rand = new int[num.intValue()];
        BigDecimal sum1 = BigDecimal.ZERO;
        BigDecimal redpeck;
        int sum = 0;
        for (int i = 0; i < num.intValue(); i++) {
            rand[i] = random.nextInt(100);
            sum += rand[i];
        }
        final BigDecimal bigDecimal = new BigDecimal(sum);
        BigDecimal remain = amount.subtract(min.multiply(num));
        for (int i = 0; i < rand.length; i++) {
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                redpeck = remain.multiply(new BigDecimal(rand[i])).divide(bigDecimal, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum1 = sum1.add(min.add(redpeck));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }

        System.out.println("校验每个红包累计额度是否等于红包总额结果：" + (amount.compareTo(sum1) == 0));
    }
}
