/*
 * 640. 求解方程
 * */
public class leetcode640 {

    public static String solveEquation(String equation) {
        int x = 0, n = 0;
        for (int i = 0; i < equation.indexOf('='); ) {
            StringBuilder sb = new StringBuilder();
            if (equation.charAt(i) == '-') {
                sb.append('-');
                i++;
            }
            while (i < equation.indexOf('=') && (equation.charAt(i) != '+' && equation.charAt(i) != '-')) {
                sb.append(equation.charAt(i++));
            }
            if (sb.indexOf("x") != -1) {
                String s = sb.substring(0, sb.length() - 1);
                if (s.equals("-")) {
                    x -= 1;
                } else if (s.equals("")) {
                    x += 1;
                } else {
                    x += Integer.parseInt(sb.substring(0, sb.length() - 1));
                }
            } else {
                n += Integer.parseInt(sb.toString());
            }
            if (equation.charAt(i) != '-') {
                i++;
            }
        }
        for (int i = equation.indexOf('=') + 1; i < equation.length(); ) {
            StringBuilder sb = new StringBuilder();
            if (equation.charAt(i) == '-') {
                sb.append('-');
                i++;
            }
            while (i < equation.length() && (equation.charAt(i) != '+' && equation.charAt(i) != '-')) {
                sb.append(equation.charAt(i++));
            }
            if (sb.indexOf("x") != -1) {
                String s = sb.substring(0, sb.length() - 1);
                if (s.equals("-")) {
                    x += 1;
                } else if (s.equals("")) {
                    x -= 1;
                } else {
                    x -= Integer.parseInt(sb.substring(0, sb.length() - 1));
                }
            } else {
                n -= Integer.parseInt(sb.toString());
            }
            if (i == equation.length() || equation.charAt(i) != '-') {
                i++;
            }
        }
        if (x == 0 && n != 0) {
            return "No solution";
        }
        return x == 0 ? "Infinite solutions" : "x=" + -n / x;
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("x-x+x=2-x"));
    }
}
