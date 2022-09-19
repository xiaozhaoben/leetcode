package algorithm.redEnvelopes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class DoubleMeanMethod {
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
            test2(amount, min, num);
        }
    }


    private static void test2(BigDecimal amount, BigDecimal min, BigDecimal num) {
        BigDecimal remain = amount.subtract(min.multiply(num));
        final Random random = new Random();
        final BigDecimal hundred = new BigDecimal("100");
        final BigDecimal two = new BigDecimal("2");
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal redpeck;
        for (int i = 0; i < num.intValue(); i++) {
            final int nextInt = random.nextInt(100);
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                redpeck = new BigDecimal(nextInt).multiply(remain.multiply(two).divide(num.subtract(new BigDecimal(i)), 2, RoundingMode.CEILING)).divide(hundred, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum = sum.add(min.add(redpeck));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }
        System.out.println("校验每个红包累计额度是否等于红包总额结果：" + amount.compareTo(sum));
    }

}
