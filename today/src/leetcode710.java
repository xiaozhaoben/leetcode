import java.util.*;

/*
* 710. 黑名单中的随机数
* */
public class leetcode710 {

//    class Solution {
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        public Solution(int n, int[] blacklist) {
//            int index = 0;
//            Arrays.sort(blacklist);
//            for (int i = 0; i < n; i++){
//                if(index >= blacklist.length || blacklist[index] != i){
//                    queue.offer(i);
//                }else {
//                    index++;
//                }
//            }
//        }
//
//        public int pick() {
//            int res = queue.poll();
//            queue.offer(res);
//            return res;
//        }
//    }

//    class Solution {
//
//        int index = 0;
//        int blackIndex = 0;
//        int[] blacklist;
//        int n;
//
//        public Solution(int n, int[] blacklist) {
//            Arrays.sort(blacklist);
//            this.blacklist = blacklist;
//            this.n = n;
//        }
//
//        public int pick() {
//            int res;
//            while (blacklist.length > 0 && index == blacklist[blackIndex]){
//                index++;
//                blackIndex++;
//                index = index == n ? 0 : index;
//                blackIndex = blackIndex == blacklist.length ? 0 : blackIndex;
//            }
//            res = index++;
//            index = index == n ? 0 : index;
//            blackIndex = index == 0 ? 0 : blackIndex;
//            return res;
//        }
//    }

    //官方解答
    class Solution {
        Map<Integer, Integer> b2w;
        Random random;
        int bound;

        public Solution(int n, int[] blacklist) {
            b2w = new HashMap<Integer, Integer>();
            random = new Random();
            int m = blacklist.length;
            bound = n - m;
            Set<Integer> black = new HashSet<Integer>();
            for (int b : blacklist) {
                if (b >= bound) {
                    black.add(b);
                }
            }

            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (black.contains(w)) {
                        ++w;
                    }
                    b2w.put(b, w);
                    ++w;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return b2w.getOrDefault(x, x);
        }
    }



}
