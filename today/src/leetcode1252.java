/*
* 1252. 奇数值单元格的数目
* */
public class leetcode1252 {

    public int oddCells(int m, int n, int[][] indices) {
        int[] a = new int[m];
        int[] b = new int[n];
        for(int i = 0; i < indices.length; i++){
            a[indices[i][0]]++;
            b[indices[i][1]]++;
        }
        int sum = 0, count = 0;
        for(int i = 0; i < m; i++){
            if(a[i] % 2 == 1){
                sum += n;
                count++;
            }
        }
        for(int i = 0; i < n; i++){
            if(b[i] % 2 == 1){
                sum += m - count * 2;
            }
        }
        return sum;
    }

}
