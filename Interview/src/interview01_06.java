/*
 * 面试题 01.06. 字符串压缩
 * */
public class interview01_06 {

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            int num = 1;
            while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                i++;
                num++;
            }
            sb.append(S.charAt(i)).append(num);
            i++;
        }
        return sb.length() == S.length() ? S : sb.toString();
    }

}
