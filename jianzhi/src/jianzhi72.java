/*
* 剑指 Offer II 071. 按权重生成随机数
* */
public class jianzhi72 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        long left = 0, right = x;
        while(left <= right){
            long mid = left + ((right - left) >> 1);
            if(mid * mid <= x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (int) right;
    }

}
