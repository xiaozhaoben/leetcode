import java.util.ArrayList;
import java.util.List;

/*
 * 592. 分数加减运算
 * */
public class leetcode592 {

    public static String fractionAddition(String expression) {

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < expression.length(); ) {
            int j = i;
            while (expression.length() > j && expression.charAt(j) != '/') {
                j++;
            }
            nums.add(Integer.valueOf(expression.substring(i, j)));
            i = j + 1;
            j = j + 1;
            while (expression.length() > j && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            nums.add(Integer.valueOf(expression.substring(i, j)));
            i = j;
        }
        int sum = 0, product = 1;
        for (int i = 1; i < nums.size(); i += 2) {
            product *= nums.get(i);
        }
        for (int i = 0; i < nums.size(); i += 2) {
            sum += nums.get(i) * (product / nums.get(i + 1));
        }
        if (sum == 0) {
            return "0/1";
        }
        for (int i = Math.abs(Math.min(sum, product)); i >= 2; i--) {
            if (sum % i == 0 && product % i == 0) {
                sum /= i;
                product /= i;
                i = Math.min(sum, product);
            }
        }
        return sum + "/" + product;
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("7/2+2/3-3/4"));
    }


}
