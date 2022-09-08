/*
 * 1592. 重新排列单词间的空格
 * */
public class leetcode1592 {

    public static String reorderSpaces(String text) {
        int space = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                space++;
            }
        }
        String[] words = text.trim().split("\\s+");
        int num = words.length;
        int surplus = num == 1 ? space : space % (num - 1);
        space = num == 1 ? 0 : space / (num - 1);
        StringBuilder sb = new StringBuilder();
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < space; i++) {
            ss.append(" ");
        }
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(words[i].trim());
            sb.append(ss);
        }
        sb.append(words[words.length - 1]);
        for (int i = 0; i < surplus; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  a"));

    }
}
