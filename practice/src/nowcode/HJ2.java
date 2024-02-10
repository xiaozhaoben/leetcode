package nowcode;

import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=">...</a>
 */
public class HJ2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String a = in.next().toUpperCase();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1).toUpperCase();
            if(c.equals(a)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}
