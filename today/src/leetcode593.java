import java.util.Arrays;

/*
 * 593. 有效的正方形
 * */
public class leetcode593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) | check(p1, p3, p2, p4) | check(p1, p4, p2, p3);
    }

    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2) || Arrays.equals(p2, p3) || Arrays.equals(p3, p4)) {
            return false;
        }
        if ((p1[0] == p2[0] && (p1[0] == p3[0] || p1[0] == p4[0]))
                || (p1[1] == p2[1] && (p1[1] == p3[1] || p1[1] == p4[1]))) {
            return false;
        }
        int k1 = (p1[1] - p2[1]) * (p3[1] - p4[1]), k2 = (p1[0] - p2[0]) * (p3[0] - p4[0]);
        if (k2 == 0 || k1 / k2 != -1) {
            if (!(k1 == 0 && k2 == 0)) {
                return false;
            }
        }
        int d1 = (p1[1] - p2[1]) * (p1[1] - p2[1]) + (p1[0] - p2[0]) * (p1[0] - p2[0]);
        int d2 = (p3[1] - p4[1]) * (p3[1] - p4[1]) + (p3[0] - p4[0]) * (p3[0] - p4[0]);
        int d3 = (p1[1] - p3[1]) * (p1[1] - p3[1]) + (p1[0] - p3[0]) * (p1[0] - p3[0]);
        int d4 = (p3[1] - p2[1]) * (p3[1] - p2[1]) + (p3[0] - p2[0]) * (p3[0] - p2[0]);
        return d1 == d2 && d3 == d4;
    }


}
