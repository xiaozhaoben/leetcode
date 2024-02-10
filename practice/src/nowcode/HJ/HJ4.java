package nowcode.HJ;

import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int left = 0, right = left + 8;
            while (right <= s.length()) {
                System.out.println(s.substring(left, right));
                left = right;
                right += 8;
            }
            StringBuilder sb = new StringBuilder();
            if (left < s.length()) {
                sb = new StringBuilder(s.substring(left, s.length()));
                while (sb.length() < 8) {
                    sb.append("0");
                }
                System.out.println(sb.toString());
            }
        }
    }
}
