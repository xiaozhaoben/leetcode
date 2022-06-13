import java.util.Arrays;

/*
* 剑指 Offer II 073. 狒狒吃香蕉
* */
public class jianzhi73 {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(!check(mid, piles, h)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int k, int[] piles, int h){
        int sum = 0;
        for(int i = 0; i < piles.length; i++){
            int cur = (piles[i] + k - 1) / k;
            sum += cur;
        }
        return sum <= h;
    }

}
