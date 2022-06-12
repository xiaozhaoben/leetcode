/*
* 剑指 Offer II 071. 按权重生成随机数
* */
public class jianzhi71 {

    class Solution {

        int[] prefix;
        int sum;

        public Solution(int[] w) {
            sum = 0;
            prefix = new int[w.length];
            for(int i = 0; i < w.length; i++){
                sum += w[i];
                prefix[i] = sum;
            }
        }

        public int pickIndex() {
            int target =(int) (Math.random() * sum);
            int left = 0, right = prefix.length - 1;
            while (left <= right){
                int mid = left + ((right - left) >> 1);
                if(target >= prefix[mid]){
                    left = mid + 1;
                }else if(target < prefix[mid]){
                    right = mid - 1;
                }
            }
            return left;
        }
    }

}
