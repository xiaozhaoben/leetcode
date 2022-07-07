import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 1217. 玩筹码
* */
public class leetcode1217 {

    public int minCostToMoveChips(int[] position) {
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < position.length; i++){
            if(position[i] % 2 == 0){
                sum1++;
            }else{
                sum2++;
            }
        }
        return Math.min(sum1, sum2);
    }


}
